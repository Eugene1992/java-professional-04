package com.cbs.edu.vladimir.hw_07;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Vladimir on 19.04.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
/**
 * MaxAnnotation.
 */
public @interface Max {
    String message();
    int max = 26;
    int maxAge() default max;
}
