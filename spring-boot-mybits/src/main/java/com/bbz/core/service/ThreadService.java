package com.bbz.core.service;

import com.bbz.core.entity.ThreadEntity;

/**
 * com.bbz.core.service
 * <p>
 * Created by tianxin2 on 2019/11/9
 */
public interface ThreadService {

    boolean save(ThreadEntity entity);

    boolean update(ThreadEntity entity);
}
