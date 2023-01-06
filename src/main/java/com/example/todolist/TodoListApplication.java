package com.example.todolist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Maple
 * @since 2023/1/2
 */
@SpringBootApplication
public class TodoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListApplication.class, args);
    }

}
