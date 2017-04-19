package homework.cw07;

import java.lang.reflect.Field;
import java.util.Collection;

public class ValidatorImpl<T> implements Validator<T> {
    /*@Override
    public void validate(Object obj) {
        Class<? extends Employee> aClass = .getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(NotNull.class)) {
                NotNull annotation = declaredField.getAnnotation(NotNull.class);
                String message = annotation.massage();
                System.out.println(declaredField.getName() + " message=[" + message + "]," );
            }
        }
    }*/

    @Override
    public void validate(Object obj) {

    }

    @Override
    public boolean validate(Collection<T> T) {
        return false;
    }
}
