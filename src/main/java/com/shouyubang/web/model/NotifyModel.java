package com.shouyubang.web.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "xml")
//@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name="WXNOTIFY")
public class NotifyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "return_code")
    private String return_code; //返回状态码

    @Column(name = "return_msg")
    private String return_msg; //返回信息

    @Column(name = "appid")
    private String appid; //公众账号ID

    @Column(name = "mch_id")
    private String mch_id; //商户号

    @Column(name = "device_info")
    private String device_info; //设备号

    @Column(name = "nonce_str")
    private String nonce_str; //随机字符串

    @Column(name = "sign")
    private String sign; //签名

    @Column(name = "sign_type")
    private String sign_type; //签名类型

    @Column(name = "result_code")
    private String result_code; //业务结果

    @Column(name = "err_code")
    private String err_code; //错误代码

    @Column(name = "err_code_des")
    private String err_code_des; //错误代码描述

    @Column(name = "openid")
    private String openid; //用户标识

    @Column(name = "is_subscribe")
    private String is_subscribe; //是否关注公众账号

    @Column(name = "trade_type")
    private String trade_type; //交易类型

    @Column(name = "bank_type")
    private String bank_type; //付款银行

    @Column(name = "total_fee")
    private int total_fee; //订单金额

    @Column(name = "settlement_total_fee")
    private int settlement_total_fee; //应结订单金额

    @Column(name = "fee_type")
    private String fee_type; //货币种类

    @Column(name = "cash_fee")
    private int cash_fee; //现金支付金额

    @Column(name = "cash_fee_type")
    private String cash_fee_type; //现金支付货币金额

    @Column(name = "coupon_fee")
    private int coupon_fee; //总代金券金额

    @Column(name = "coupon_count")
    private int coupon_count; //代金券使用数量

    @Column(name = "coupon_type_$n")
    private int coupon_type_$n; //代金券类型

    @Column(name = "coupon_id_$n")
    private String coupon_id_$n; //代金券ID

    @Column(name = "coupon_fee_$n")
    private int coupon_fee_$n;//单个代金券支付金额

    @Column(name = "transaction_id")
    private String transaction_id; //微信支付订单号

    @Column(name = "out_trade_no")
    private String out_trade_no; //商户订单号

    @Column(name = "attach")
    private String attach; //商户数据包

    @Column(name = "time_end")
    private String time_end; //支付完成时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public int getSettlement_total_fee() {
        return settlement_total_fee;
    }

    public void setSettlement_total_fee(int settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public int getCash_fee() {
        return cash_fee;
    }

    public void setCash_fee(int cash_fee) {
        this.cash_fee = cash_fee;
    }

    public String getCash_fee_type() {
        return cash_fee_type;
    }

    public void setCash_fee_type(String cash_fee_type) {
        this.cash_fee_type = cash_fee_type;
    }

    public int getCoupon_fee() {
        return coupon_fee;
    }

    public void setCoupon_fee(int coupon_fee) {
        this.coupon_fee = coupon_fee;
    }

    public int getCoupon_count() {
        return coupon_count;
    }

    public void setCoupon_count(int coupon_count) {
        this.coupon_count = coupon_count;
    }

    public int getCoupon_type_$n() {
        return coupon_type_$n;
    }

    public void setCoupon_type_$n(int coupon_type_$n) {
        this.coupon_type_$n = coupon_type_$n;
    }

    public String getCoupon_id_$n() {
        return coupon_id_$n;
    }

    public void setCoupon_id_$n(String coupon_id_$n) {
        this.coupon_id_$n = coupon_id_$n;
    }

    public int getCoupon_fee_$n() {
        return coupon_fee_$n;
    }

    public void setCoupon_fee_$n(int coupon_fee_$n) {
        this.coupon_fee_$n = coupon_fee_$n;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTime_end() {
        return time_end;
    }

    public void setTime_end(String time_end) {
        this.time_end = time_end;
    }

    @Override
    public String toString() {
        return "NotifyModel{" +
                "id=" + id +
                ", return_code='" + return_code + '\'' +
                ", return_msg='" + return_msg + '\'' +
                ", appid='" + appid + '\'' +
                ", mch_id='" + mch_id + '\'' +
                ", device_info='" + device_info + '\'' +
                ", nonce_str='" + nonce_str + '\'' +
                ", sign='" + sign + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", result_code='" + result_code + '\'' +
                ", err_code='" + err_code + '\'' +
                ", err_code_des='" + err_code_des + '\'' +
                ", openid='" + openid + '\'' +
                ", is_subscribe='" + is_subscribe + '\'' +
                ", trade_type='" + trade_type + '\'' +
                ", bank_type='" + bank_type + '\'' +
                ", total_fee=" + total_fee +
                ", settlement_total_fee=" + settlement_total_fee +
                ", fee_type='" + fee_type + '\'' +
                ", cash_fee=" + cash_fee +
                ", cash_fee_type='" + cash_fee_type + '\'' +
                ", coupon_fee=" + coupon_fee +
                ", coupon_count=" + coupon_count +
                ", coupon_type_$n=" + coupon_type_$n +
                ", coupon_id_$n='" + coupon_id_$n + '\'' +
                ", coupon_fee_$n=" + coupon_fee_$n +
                ", transaction_id='" + transaction_id + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", attach='" + attach + '\'' +
                ", time_end='" + time_end + '\'' +
                '}';
    }
}
