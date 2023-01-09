package com.example.todolist.exception;

import com.example.todolist.common.R;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author Maple
 * @since 2023/1/2
 **/
@RestControllerAdvice
public class CommonExceptionHandler {
    private static String VALID_ERROR_MSG = "参数校验异常！";
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return R.fail(VALID_ERROR_MSG);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public R constraintViolationException(ConstraintViolationException e) {
        return R.fail(VALID_ERROR_MSG);
    }
    @ExceptionHandler(ValidException.class)
    public R validException(ValidException e) {
        return R.fail(VALID_ERROR_MSG);
    }

    @ExceptionHandler(GeneralException.class)
    public R generalException(GeneralException e) {
        return R.fail(e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public R exception(Exception e) {
        return R.fail("发生内部错误");
    }
}
