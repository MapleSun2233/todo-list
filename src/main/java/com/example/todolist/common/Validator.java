package com.example.todolist.common;

import com.example.todolist.exception.ValidException;
import lombok.AllArgsConstructor;

import java.util.function.Predicate;

/**
 * @author Maple
 * @since 2023/1/2
 **/
@AllArgsConstructor
public class Validator<T> {
    private T data;
    private Predicate<T> predicate;
    private String errorMessage;

    public static <T> Validator<T> create(T data, Predicate<T> predicate) {
        return new Validator<>(data, predicate, "参数非法");
    }
    public static <T> Validator<T> create(T data, Predicate<T> predicate, String errorMessage) {
        return new Validator<>(data, predicate, errorMessage);
    }

    public boolean validate() {
        return predicate.test(data);
    }

    public ValidException getThrowable() {
        return new ValidException("参数验证错误：" + errorMessage);
    }
}
