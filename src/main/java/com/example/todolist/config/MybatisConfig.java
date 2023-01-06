package com.example.todolist.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;

/**
 * @author Maple
 * @since 2023/1/6
 **/
@Configuration
@MapperScan("com.example.todolist.mapper")
@EnableTransactionManagement
public class MybatisConfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
