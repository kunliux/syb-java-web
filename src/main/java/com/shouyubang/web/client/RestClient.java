package com.shouyubang.web.client;

import com.shouyubang.web.constants.APIConstants;
import com.shouyubang.web.model.WXOrderVO;
import com.shouyubang.web.utils.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by KunLiu on 2017/3/22.
 */

@RestController
public class RestClient {

    @Autowired
    private XMLService xmlService;

    public String getPrePayId(WXOrderVO wxOrderVO) {
        final String url = APIConstants.UNIFIED_ORDER_URL;
        String requestXml= "";
        String returnXml = ""; // 核心返回结果报文字符串
        String prepay_id = "";


        try {

            //复杂构造函数的使用
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            requestFactory.setConnectTimeout(1000);// 设置超时
            requestFactory.setReadTimeout(1000);

            //利用复杂构造器可以实现超时设置，内部实际实现为 HttpClient
            RestTemplate restTemplate = new RestTemplate(requestFactory);

            //设置HTTP请求头信息，实现编码等
            HttpHeaders requestHeaders = new HttpHeaders();
            // requestHeaders.set("Accept", "text/");
            requestHeaders.set("Accept-Charset", "UTF-8");
            requestHeaders.set("Content-type", "application/xml; charset=UTF-8");// 设置编码

            //利用容器实现数据封装，发送
            requestXml = objectToXmlStr(wxOrderVO);
            requestXml = new String(requestXml.getBytes("ISO-8859-1"), "UTF-8");
            HttpEntity<String> entity = new HttpEntity<String>(requestXml, requestHeaders);
            System.out.println(requestXml);
            returnXml = restTemplate.postForObject(url, entity, String.class);
            returnXml = new String(returnXml.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(returnXml);
            Map map = xmlService.doXMLParse(returnXml);
            String return_code = (String) map.get("return_code");
            String result_code;
            if (return_code.contains("SUCCESS")) {
                result_code = (String) map.get("result_code");
                if(result_code.contains("SUCCESS"))
                    prepay_id = (String) map.get("prepay_id");//获取到prepay_id
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(null == prepay_id || prepay_id.isEmpty())
            return "FAIL";
        else
            return prepay_id;



    }

    public static String objectToXmlStr(Object object) throws JAXBException {


        if (object == null) return "";

        System.out.println("把对象转换为xml字符串");

        OutputStream out = new ByteArrayOutputStream();

        JAXBContext context = JAXBContext.newInstance(object.getClass());

        Marshaller jaxbMarshaller = context.createMarshaller();

        //是否格式化输出xml文件
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //设置编码
        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");


        //打印到输出流中
        jaxbMarshaller.marshal(object,out);

        return out.toString();
    }

}
