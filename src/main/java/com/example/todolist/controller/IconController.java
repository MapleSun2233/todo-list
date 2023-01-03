package com.example.todolist.controller;

import com.example.todolist.common.R;
import com.example.todolist.service.IconService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 图标表 前端控制器
 * </p>
 *
 * @author Maple
 * @since 2023-01-02
 */
@RestController
@RequestMapping("/icon")
@Api(tags = "图标管理")
public class IconController {
    @Resource
    private IconService iconService;

    @ApiOperation("全部图标")
    @GetMapping
    public R list() {
        return R.ok(iconService.list());
    }
}
