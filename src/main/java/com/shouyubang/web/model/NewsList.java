package com.shouyubang.web.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by SYL on 2017/10/23.
 */
@Entity
@Table(name="NEWS")
public class NewsList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//
////    @NotNull
////    @Column(name = "TOPIC", nullable = false)
////    private String topic ;
////    
////    @NotNull
////    @Column(name = "topicImg", nullable = false)
////    private String topicImg;
//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getTopicImg() {
//        return topicImg;
//    }
//
//    public void setTopicImg(String topicImg) {
//        this.topicImg = topicImg;
//    }
//
//    public String getTopic() {
//        return topic;
//    }
//
//    public void setTopic(String topic) {
//        this.topic = topic;
//    }
}
