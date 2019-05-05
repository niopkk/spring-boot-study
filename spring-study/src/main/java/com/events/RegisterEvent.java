package com.events;

import org.springframework.context.ApplicationEvent;

/**
 * com.events
 * <p>
 * Created by tianxin2 on 2019-05-03
 */

public class RegisterEvent extends ApplicationEvent {


    private String message;

    public RegisterEvent(Object source,String message) {
        super(source);
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
