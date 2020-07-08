package com.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;


public class MagicExistsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        System.out.println(environment.getProperty("spring.profiles.active"));
        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        System.out.println(Arrays.asList(activeProfiles));


        return environment.containsProperty("magic");
    }
}
