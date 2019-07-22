package com.bbz.annotation03;

/**
 * com.bbz.annotation03
 * <p>
 * Created by tianxin2 on 2019-07-22
 */
public class AnnotationTracker {

    public static void annotationTracker(Class<?> cls) {
        CETAnnotation cetAnnotation = cls.getAnnotation(CETAnnotation.class);
        if (cetAnnotation != null) {
            cetAnnotation.annotationType().getClass();
            System.out.println("id...." + cetAnnotation.id());
        }
    }
}

