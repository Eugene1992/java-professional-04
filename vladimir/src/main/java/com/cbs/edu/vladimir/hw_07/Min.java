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
public @interface Min {
    String message();
    int DEFAULT_MIN_VALUE = 18;
    int minAge() default DEFAULT_MIN_VALUE;
}
