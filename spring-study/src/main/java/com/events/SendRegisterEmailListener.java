package com.events;

import org.springframework.context.ApplicationListener;

/**
 * com.events
 * <p>
 * Created by tianxin2 on 2019-05-03
 */
public class SendRegisterEmailListener implements ApplicationListener<RegisterEvent> {
    @Override
    public void onApplicationEvent(RegisterEvent registerEvent) {
        try {

            Thread.sleep(3*1000);
        }catch (Exception e){

        }
    }
}
