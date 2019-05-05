package com.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * com.events
 * <p>
 * Created by tianxin2 on 2019-05-03
 */
@Component
public class RegisterEventPublisher {


    @Autowired
    private ApplicationEventPublisher publisher;


    public void publisher(final String message) {


        RegisterEvent registerEvent = new RegisterEvent(this, message);

        publisher.publishEvent(registerEvent);
    }
}
