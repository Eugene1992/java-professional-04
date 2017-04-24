package com.cbs.edu.vladimir.hw_07;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Vladimir on 19.04.2017.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(value = {ElementType.METHOD, ElementType.FIELD})
public @interface Size {
    String message();

    int size();
}
