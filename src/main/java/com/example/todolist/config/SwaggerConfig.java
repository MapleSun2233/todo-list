package com.example.todolist.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Maple
 * @since 2023/1/2
 **/
@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Value("${swagger.enable}")
    private boolean enable;
    @Bean
    public Docket createRestDocket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build().enable(enable);
    }
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .build();
    }
}
