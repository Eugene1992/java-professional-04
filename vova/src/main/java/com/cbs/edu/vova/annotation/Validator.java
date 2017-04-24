package com.cbs.edu.vova.annotation;

import java.util.Collection;

/** Interface validator for data.
 * @param <T> type.
 */
public interface Validator<T> {
    boolean validate(T type);

    boolean validate(Collection<T> collection);
}
