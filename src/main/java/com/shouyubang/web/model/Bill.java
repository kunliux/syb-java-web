package com.shouyubang.web.model;

import javax.persistence.*;


@Entity
@Table(name="BILL")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "totalFee")
    private int totalFee;

    @Column(name = "body")
    private String body; //商品说明

    @Column(name = "timeCreate")
    private String timeCreate; //创建时间

    @Column(name = "tradeNo")
    private String tradeNo; //商户订单号

    @Column(name = "ownId")
    private String ownId; //自己ID

    @Column(name = "peerId")
    private String peerId; //对方ID

    @Column(name = "payMethod")
    private String payMethod; //支付方式

    @Column(name = "payParam")
    private String payParam; //支付订单号

    @Column(name = "callDuration")
    private int callDuration;

    @Column(name = "payStatus")
    private int payStatus;//未到账0，到账1

    @Column(name = "createIp")
    private String createIp;//ip

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(String timeCreate) {
        this.timeCreate = timeCreate;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOwnId() {
        return ownId;
    }

    public void setOwnId(String ownId) {
        this.ownId = ownId;
    }

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayParam() {
        return payParam;
    }

    public void setPayParam(String payParam) {
        this.payParam = payParam;
    }

    public int getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(int callDuration) {
        this.callDuration = callDuration;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", totalFee=" + totalFee +
                ", body='" + body + '\'' +
                ", timeCreate='" + timeCreate + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", ownId='" + ownId + '\'' +
                ", peerId='" + peerId + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", payParam='" + payParam + '\'' +
                ", callDuration=" + callDuration +
                ", payStatus=" + payStatus +
                ", createIp=" + createIp +
                '}';
    }
}
