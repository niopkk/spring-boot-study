package com.bbz.annotation03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * com.bbz.annotation03
 * <p>
 * Created by tianxin2 on 2019-07-22
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CETMethodAnnotation {
    String value() default "";
}
