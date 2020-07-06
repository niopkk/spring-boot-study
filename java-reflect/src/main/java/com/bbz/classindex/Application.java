package com.bbz.classindex;


import org.atteo.classindex.IndexAnnotated;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@IndexAnnotated
public @interface Application {

    String id();

    String label() default "";

}
