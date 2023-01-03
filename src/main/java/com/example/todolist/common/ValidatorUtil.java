package com.example.todolist.common;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Maple
 * @since 2023/1/2
 **/
public class ValidatorUtil {
    private List<Validator> validators = new ArrayList<>();
    public static ValidatorUtil create() {
        return new ValidatorUtil();
    }

    public <T> ValidatorUtil append(T data, Predicate<T> predicate) {
        validators.add(Validator.create(data, predicate));
        return this;
    }
    public <T> ValidatorUtil append(T data, Predicate<T> predicate, String errorMessage) {
        validators.add(Validator.create(data, predicate, errorMessage));
        return this;
    }

    public void validate() {
        validators.forEach(validator -> {
            if (!validator.validate()) {
                throw validator.getThrowable();
            }
        });
    }
    public static <T> void validate(T data, Predicate<T> predicate) {
        Validator.create(data, predicate).validate();
    }
}
