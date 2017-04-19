package homework.cw07;

import java.util.Collection;

public interface Validator<T>{
    void validate(Object obj);
    boolean validate(Collection<T> T);
}
