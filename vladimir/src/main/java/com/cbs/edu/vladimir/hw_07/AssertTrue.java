package com.cbs.edu.vladimir.hw_07;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Vladimir on 19.04.2017.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AssertTrue {
    String message();

    boolean trueOrFalse() default false;
}
