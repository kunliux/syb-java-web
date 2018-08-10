package com.shouyubang.web.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by KunLiu on 2017/3/20.
 */

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class WXOrderVO  implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement
    private String appid;

    @XmlElement( name = "mch_id")
    private String mchId;

    @XmlElement( name = "device_info")
    private String deviceInfo;

    @XmlElement( name = "nonce_str")
    private String nonceStr;

    @XmlElement
    private String sign;

    @XmlElement( name = "sign_type")
    private String signType;

    @XmlElement
    private String body;

    @XmlElement
    private String detail;

    @XmlElement
    private String attach;

    @XmlElement( name = "out_trade_no")
    private String outTradeNo;

    @XmlElement( name = "fee_type")
    private String feeType;

    @XmlElement( name = "total_fee")
    private int totalFee; //单位为分

    @XmlElement( name = "spbill_create_ip")
    private String spbillCreateIp;

    @XmlElement( name = "time_start")
    private String timeStart; //格式为yyyyMMddHHmmss

    @XmlElement( name = "time_expire")
    private String timeExpire;

    @XmlElement( name = "goods_tag")
    private String goodsTag;

    @XmlElement( name = "notify_url")
    private String notifyUrl;

    @XmlElement( name = "trade_type")
    private String tradeType;

    @XmlElement( name = "product_id")
    private String productId; //trade_type=NATIVE时（即扫码支付），此参数必传

    @XmlElement( name = "limit_pay")
    private String limitPay;

    @XmlElement
    private String openid; //trade_type=JSAPI时（即公众号支付），此参数必传

    public WXOrderVO() {
        super();
    }

    public WXOrderVO(String appid, String mchId, String deviceInfo, String nonceStr, String sign, String signType, String body, String detail, String attach, String outTradeNo, String feeType, int totalFee, String spbillCreateIp, String timeStart, String timeExpire, String goodsTag, String notifyUrl, String tradeType, String productId, String limitPay, String openid) {
        this.appid = appid;
        this.mchId = mchId;
        this.deviceInfo = deviceInfo;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.signType = signType;
        this.body = body;
        this.detail = detail;
        this.attach = attach;
        this.outTradeNo = outTradeNo;
        this.feeType = feeType;
        this.totalFee = totalFee;
        this.spbillCreateIp = spbillCreateIp;
        this.timeStart = timeStart;
        this.timeExpire = timeExpire;
        this.goodsTag = goodsTag;
        this.notifyUrl = notifyUrl;
        this.tradeType = tradeType;
        this.productId = productId;
        this.limitPay = limitPay;
        this.openid = openid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeExpire(String timeExpire) {
        this.timeExpire = timeExpire;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setLimitPay(String limitPay) {
        this.limitPay = limitPay;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
