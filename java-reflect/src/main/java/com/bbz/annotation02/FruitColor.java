package com.bbz.annotation02;

import java.lang.annotation.*;

/**
 * 水果颜色注解
 *
 * @author peida
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    enum Color {BULE, RED, GREEN}


    Color fruitColor() default Color.RED;
}
