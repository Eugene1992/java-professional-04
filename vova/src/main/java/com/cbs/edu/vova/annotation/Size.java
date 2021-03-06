package com.cbs.edu.vova.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by User on 19.04.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Size {
    /** Some method.
     * @return int.
     */
    int size() default 10;

    /** Some method.
     * @return message.
     */
    String message() default "Default size is 10";
}
