package com.annotation_study.condition;

import com.annotation_study.pojo.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

//        importingClassMetadata.getAnnotationAttributes()

        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();

        annotationTypes.stream().forEach(s -> System.out.println("myImportBean:" + s));

        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
        registry.registerBeanDefinition("rainbow", rootBeanDefinition);
    }
}
