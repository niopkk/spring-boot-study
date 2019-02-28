package com.spirngannotation.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MyComponent {

    String value() default "";
}
