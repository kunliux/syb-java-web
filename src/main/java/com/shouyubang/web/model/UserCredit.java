package com.shouyubang.web.model;

import javax.persistence.*;

/**
 *
 * @author KunLiu
 * @date 2017/7/17
 */

@Entity
@Table(name="USERCREDIT")
public class UserCredit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USERID")
    private String userId;    //用户名

    @Column(name = "BALANCE")   //用户余额，以分为单位
    private int balance;

    @Column(name = "POINTS")    //用户积分
    private int points;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "UserCredit{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", balance=" + balance +
                ", points=" + points +
                '}';
    }
}