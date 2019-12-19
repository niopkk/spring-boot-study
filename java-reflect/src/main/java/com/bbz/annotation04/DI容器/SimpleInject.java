package com.bbz.annotation04.DI容器;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/**
 * com.bbz.annotation04.DI容器
 * <p>
 * Created by tianxin2 on 2019/12/19
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleInject {

}
