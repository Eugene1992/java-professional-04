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
public @interface AssertTrue {
    /** Some method.
     * @return bool.
     */
    boolean bool() default false;

    /** Some method.
     * @return message.
     */
    String message() default "It shoud be true or false";
}
