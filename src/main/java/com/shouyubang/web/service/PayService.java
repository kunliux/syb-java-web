package com.shouyubang.web.service;

import com.shouyubang.web.client.RestClient;
import com.shouyubang.web.constants.APIConstants;
import com.shouyubang.web.dao.*;
import com.shouyubang.web.model.*;
import com.shouyubang.web.utils.MD5Service;
import com.shouyubang.web.utils.TimeService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class PayService {

    @Autowired
    private MD5Service md5Service;

    @Autowired
    private NotifyDao notifyDao;

    @Autowired
    private  RestClient restClient;

    @Autowired
    private BillDao billDao;

    @Autowired
    private TimeService timeService;

    @Autowired
    private  CallDao callDao;

    @Autowired
    private  UserCreditDao userCreditDao;


    public void genOrder(Bill bill) {

//        Bill entity = billDao.getBillById(bill.getId());
//        bill.setOwnId(bill.getOwnId());
        if(!bill.getOwnId().isEmpty()) {
//
//
            String billId = getOutTradeNo("wx");
            String curTime = timeService.getCurTime();


//        Integer totalDuration = callDao.getTotalDurationByQuestionId(questionId);
//        Integer totalFee = totalDuration * APIConstants.PRICE_RATIO + q.getPrice();
//        Integer totalFee =10;
            bill.setTotalFee(bill.getTotalFee());
//        bill.setCallDuration(totalDuration);
            System.out.print("订单金额：" + bill.getTotalFee());
            bill.setTimeCreate(curTime);
            bill.setTradeNo(billId);

            bill.setPayMethod("WEIXIN"); //默认微信支付

            String prepayId = getPrepayId(bill.getBody(), bill.getTotalFee() + "", bill.getCreateIp(), billId);

            if (!prepayId.equals("FAIL")) {
                bill.setPayParam(prepayId);
            } else {
                bill.setPayParam("FAIL");
            }
            billDao.saveBill(bill);
        }
    }

    public Response wxPrepay(String tradeNo, String createIp) {
        Response result = new Response(104,"SUCCESS");
        Bill bill = billDao.getBillByTradeNo(tradeNo);
        if(null == bill) {
            result.setCode(-15);
            result.setMessage("订单不存在");
            return result;
        }

        String body = bill.getBody();
        String totalFee = bill.getTotalFee()+"";
        String prepayId = getPrepayId(body, totalFee, createIp, tradeNo);

        if(!prepayId.equals("FAIL")) {
            result.setCode(104);
            result.setMessage("SUCCESS");
            result.setData(prepayId);
        } else {
            result.setCode(-3);
            result.setMessage("生成预付单失败");

        }
        return result;
    }

    //上一次订单请求日期
    private Date preDay = new Date();
    //当前订单日期
    private Date curDay = new Date();
    //用于记录已产生的订单号
    private Set<Long> numPoul = new HashSet<Long>();

    //定义签名，微信根据参数字段的ASCII码值进行排序 加密签名,故使用SortMap进行参数排序
    private String createSign(String characterEncoding, SortedMap<String, String> parameters){
        StringBuilder sb = new StringBuilder();
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + APIConstants.PARTNER_KEY);//最后加密时添加商户密钥，由于key值放在最后，所以不用添加到SortMap里面去，单独处理，编码方式采用UTF-8
        return md5Service.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
    }

    /**
     * 获得签名
     * @param params 待编码参数，参数值为空不传入
     * @param key key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
     * @return
     */
    public String getSign(Map<String, String> params, String key){
        List<String> list = new ArrayList<String>(params.keySet());
        list.sort(new DictionaryCompare());
        StringBuilder sb = new StringBuilder();
        for(String keyVal:list){
            sb.append(keyVal+"="+params.get(keyVal)+"&");
        }
        sb.append("key="+key);
        return DigestUtils.md5Hex(sb.toString()).toUpperCase();
    }

    /**
     * 获得随机字符串
     * @return
     */
    public String getNonceStr(){
        Random random = new Random();
        long val = random.nextLong();
        String res = DigestUtils.md5Hex(val+"xyz").toUpperCase();
        if(32<res.length()) return res.substring(0,32);
        else return res;
    }

    private String genNonceStr() {
        Random random = new Random();
        return md5Service.getMessageDigest(String.valueOf(random.nextInt(10000))
                .getBytes());
    }

    /**
     * 获取订单号
     * 商户订单号（每个订单号必须唯一）
     * 组成：mch_id+yyyymmdd+10位一天内不能重复的数字。
     * @param mchId
     * @return
     */
    private String getOutTradeNo(String mchId){
        Random random = new Random();
        long val = Math.abs(random.nextLong()%10000000000L);//获得0-9999999999内的数字
        curDay = new Date();
        //隔天清空
        if(curDay.after(preDay)) numPoul.clear();
        while(numPoul.contains(val)){
            val = random.nextLong()%10000000000L;

        }
        numPoul.add(val);
        String s = String.valueOf(val);

        for(int i = 0; i < 10-s.length(); i++)
          s ="0"+ s ;

//        }
        preDay = curDay;
        //按要求，日期格式化输出
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        return mchId+df.format(curDay)+s;
    }

    /**
     * 将字符串str按长度在前面添0补齐
     * @param str
     * @param length
     * @return
     */
//    private String format(String str,int length){
//        String pre = "0000000000";
//        int len = str.length();
//        if(10<=len) return str.substring(0,10);
//        else return pre.substring(0,10-len).concat(str);
//    }

    /**
     * 按字典序排序
     */
    class DictionaryCompare implements Comparator<String> {
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }


    public void handleNotifyMsg(NotifyModel notify) {
         notifyDao.saveNotifyMsg(notify);
    }

    private String getPrepayId(String body, String totalFee, String createIp, String tradeNo) {

        String notifyUrl = APIConstants.WEI_XIN_NOTIFY_URL;//回调地址
        String nonceStr = getNonceStr();
        WXOrderVO order = new WXOrderVO();
        order.setAppid(APIConstants.APP_ID);
        order.setBody(body);
        order.setMchId(APIConstants.PARTNER);
        order.setNonceStr(nonceStr);
        order.setNotifyUrl(notifyUrl);
        order.setOutTradeNo(tradeNo);
        order.setSpbillCreateIp(createIp);
        order.setTotalFee(Integer.valueOf(totalFee));
        order.setTradeType("APP");

        SortedMap<String, String> signParams = new TreeMap<String, String>();
        signParams.put("appid", APIConstants.APP_ID);//app_id
        signParams.put("body", body);//商品参数信息
        signParams.put("mch_id", APIConstants.PARTNER);//微信商户账号
        signParams.put("nonce_str", nonceStr);//32位不重复的编号
        signParams.put("notify_url", notifyUrl);//回调页面
        signParams.put("out_trade_no", tradeNo);//订单编号
        signParams.put("spbill_create_ip", createIp);//请求的实际ip地址
        signParams.put("total_fee", totalFee);//支付金额 单位为分
        signParams.put("trade_type", "APP"); //付款类型为APP
        String sign = createSign("UTF-8", signParams);//生成签名
        order.setSign(sign);

        return restClient.getPrePayId(order);
    }

    public List<Bill> getStudentBills(String userId) {
        if(userId.isEmpty())
            return null;
        else
            return billDao.getBillsByOwnId(userId);
    }


    public int checkOutBill(String tradeNo) {
            return billDao.getBillStatus(tradeNo);
    }

    public void updateBillAndCredit(String tradeNo,int totalFee) {
        Bill entity = billDao.getBillByTradeNo(tradeNo);
        if(entity!=null){
            entity.setPayStatus(1);
        UserCredit entity2=userCreditDao.getUserCreditByUserId(entity.getOwnId());
        entity2.setBalance(entity2.getBalance()+ totalFee);
        }
    }
}


