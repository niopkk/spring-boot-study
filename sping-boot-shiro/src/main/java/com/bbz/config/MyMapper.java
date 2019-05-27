package com.bbz.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * com.bbz.config
 * <p>
 * Created by tianxin2 on 2019-05-27
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
