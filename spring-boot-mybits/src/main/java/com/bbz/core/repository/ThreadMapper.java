package com.bbz.core.repository;

import com.bbz.core.entity.ThreadEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * com.bbz.core.repository
 * <p>
 * Created by tianxin2 on 2019/11/9
 */
@Repository
@Mapper
public interface ThreadMapper {

    boolean save(ThreadEntity entity);

    boolean update(ThreadEntity entity);
}
