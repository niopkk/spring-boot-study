package com.bbz.task;

import com.bbz.core.entity.ThreadEntity;
import com.bbz.core.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * com.bbz.task
 * <p>
 * Created by tianxin2 on 2019/11/9
 */
@Component
public class ThreadTask {

    @Autowired
    private ThreadService threadService;

//    @Scheduled(cron = "0/2 * *  * * ?")
    public void update() {

        System.out.println("进入任务:" + System.currentTimeMillis());
        ThreadEntity threadEntity = new ThreadEntity();
        threadEntity.setId(1);
        threadEntity.setDes("scheduled.....");
        threadEntity.setName("scheduled 修改");

        threadService.update(threadEntity);


    }
}
