package com.annotation_study.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {


        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");

        if (property.contains("Window")) {
            return true;
        }

        System.out.println(environment.getProperty("os.name"));

        return false;
    }
}
