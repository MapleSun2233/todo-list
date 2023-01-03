package com.example.todolist.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Maple
 * @since 2023/1/2
 **/
@AllArgsConstructor
@Getter
public class GeneralException extends RuntimeException{
    private int code;
    private String msg;
}
