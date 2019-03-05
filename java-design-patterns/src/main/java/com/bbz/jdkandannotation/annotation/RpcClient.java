package com.bbz.jdkandannotation.annotation;

import org.springframework.context.event.EventListener;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RpcClient {
    String value() default "";

}
