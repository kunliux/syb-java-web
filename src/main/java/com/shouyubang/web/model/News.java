package com.shouyubang.web.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.soap.Text;
import java.util.Map;

@Entity
@Table(name="NEWS")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "BODY", nullable = false)
    private String body;

//    @NotNull
//    @Column(name = "topicImg", nullable = false)
//    private String topicImg;

    @NotNull
    @Column(name = "TOPIC", nullable = false)
    private String topic ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

//    public String getTopicImg() {
//        return topicImg;
//    }
//
//    public void setTopicImg(String topicImg) {
//        this.topicImg = topicImg;
//    }@Override

}
