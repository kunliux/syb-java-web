package com.shouyubang.web.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by KunLiu on 2017/3/22.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class PrePayVO  implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "return_code")
    private String returnCode;

    @XmlElement(name = "return_msg")
    private String returnMsg;

    @XmlElement
    private String appid;

    @XmlElement(name = "mch_id")
    private String mchId;

    @XmlElement(name = "device_info")
    private String deviceInfo;

    @XmlElement(name = "nonce_str")
    private String nonceStr;

    @XmlElement
    private String sign;

    @XmlElement(name = "result_code")
    private String resultCode;

    @XmlElement(name = "err_code")
    private String errCode;

    @XmlElement(name = "err_code_des")
    private String errCodeDes;

    @XmlElement(name = "trade_type")
    private String tradeType;

    @XmlElement(name = "prepay_id")
    private String prepayId;

    public PrePayVO() {
        super();
    }

    public PrePayVO(String returnCode, String returnMsg, String appid, String mchId, String deviceInfo, String nonceStr, String sign, String resultCode, String errCode, String errCodeDes, String tradeType, String prepayId) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.appid = appid;
        this.mchId = mchId;
        this.deviceInfo = deviceInfo;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.resultCode = resultCode;
        this.errCode = errCode;
        this.errCodeDes = errCodeDes;
        this.tradeType = tradeType;
        this.prepayId = prepayId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public String getAppid() {
        return appid;
    }

    public String getMchId() {
        return mchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrCodeDes() {
        return errCodeDes;
    }

    public String getTradeType() {
        return tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }
}
