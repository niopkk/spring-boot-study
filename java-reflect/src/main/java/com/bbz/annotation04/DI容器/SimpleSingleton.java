package com.bbz.annotation04.DI容器;

/**
 * com.bbz.annotation04.DI容器
 * <p>
 * Created by tianxin2 on 2019/12/19
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimpleSingleton {
}
