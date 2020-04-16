package com.annotationstudy.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class ImportMySelect implements ImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> annotationTypes =
                importingClassMetadata.getAnnotationTypes();

        annotationTypes.stream().forEach(s -> System.out.println(">>>>>>" + s));

        return new String[]
                {"com.annotationstudy.config.red", "com.annotationstudy.config.black" };
    }
}
