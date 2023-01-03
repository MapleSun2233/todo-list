package com.example.todolist;

//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.FastAutoGenerator;
//import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//import com.baomidou.mybatisplus.generator.fill.Column;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * @Author Maple
 * @Date 2023/1/2
 **/
public class GenerateTest {
    @Test
    public void generate() {
//        FastAutoGenerator.create("jdbc:mysql://localhost:3306/todo_list?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai", "root", "root")
//                .globalConfig(builder -> {
//                    builder.author("Maple") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
//                            .outputDir("D:\\IdeaProjects\\todo-list\\src\\main\\java"); // 指定输出目录
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.example.todolist") // 设置父包名
//                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\IdeaProjects\\todo-list\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
//                })
//                .strategyConfig(builder -> {
//                    builder.addInclude("t_group", "t_icon", "t_task") // 设置需要生成的表名
//                            .addTablePrefix("t_") // 设置过滤表前缀
//                            .entityBuilder()
//                            .disableSerialVersionUID()
//                            .enableRemoveIsPrefix()
//                            .idType(IdType.NONE)
//                            .addTableFills(new Column("create_time", FieldFill.INSERT))
//                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
//                            .enableLombok()
//                            .build()
//                            .controllerBuilder()
//                            .enableRestStyle()
//                            .build();
//                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
//                .execute();
    }
}
