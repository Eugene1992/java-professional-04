package com.cbs.edu.examples.cw_07;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD, ElementType.METHOD})
public @interface MyAnnotation {

    String message() default "default value...";
    int value() default 0;
}
