package com.example.todolist.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Maple
 * @since 2023/1/2
 **/
@AllArgsConstructor
@Getter
public class ValidException extends RuntimeException{
    private String msg;

}
