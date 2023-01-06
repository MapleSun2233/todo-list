package com.example.todolist.common;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Maple
 * @since 2023/1/2
 **/
@Builder
@Getter
@ToString
public class R<T> {
    private int code;
    private String msg;
    private T data;


    public static R ok() {
        return R.builder().code(200).msg("").build();
    }
    public static <T> R ok(T data) {
        return R.builder().code(200).msg("").data(data).build();
    }

    public static R fail() {
        return R.builder().code(400).msg("").build();
    }
    public static R fail(String msg) {
        return R.builder().code(400).msg(msg).build();
    }
}
