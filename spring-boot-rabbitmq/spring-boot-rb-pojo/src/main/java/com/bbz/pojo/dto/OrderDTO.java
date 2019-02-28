package com.bbz.pojo.dto;

import java.io.Serializable;

public class OrderDTO implements Serializable {


    private static final long serialVersionUID = -3743653320109674370L;

    private String id;


    private String name;


    private String messageId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
