package com.bbz.core.service.impl;

import com.bbz.core.entity.ThreadEntity;
import com.bbz.core.repository.ThreadMapper;
import com.bbz.core.service.ThreadService;
import com.bbz.core.service.ThreadTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.bbz.core.service.impl
 * <p>
 * Created by tianxin2 on 2019/11/9
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private ThreadMapper threadMapper;

    //@PostConstruct
    private void init() {
        new Thread(new ThreadTest(this)).start();
    }

    @Override
    public boolean save(ThreadEntity entity) {
        return threadMapper.save(entity);

    }

    @Override
    public boolean update(ThreadEntity entity) {
        return threadMapper.update(entity);
    }
}
