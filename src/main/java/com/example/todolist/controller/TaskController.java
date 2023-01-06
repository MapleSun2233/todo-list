package com.example.todolist.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.example.todolist.common.R;
import com.example.todolist.dto.AddTaskDto;
import com.example.todolist.dto.MarkTaskDto;
import com.example.todolist.dto.UpdateTaskDto;
import com.example.todolist.entity.Task;
import com.example.todolist.service.TaskService;
import com.example.todolist.vo.DefaultGroupTaskCountVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 任务表 前端控制器
 * </p>
 *
 * @author Maple
 * @since 2023-01-02
 */
@RestController
@RequestMapping("/task")
@Api(tags = "任务管理")
public class TaskController {
    @Resource
    private TaskService taskService;

    @ApiOperation("全部任务")
    @GetMapping
    public R listAll() {
        return R.ok(taskService.list());
    }

    @ApiOperation("已完成任务")
    @GetMapping("/completed")
    public R listCompleted() {
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Task::getCompleted, true)
                .orderByDesc(Task::getCreateTime);
        return R.ok(taskService.list(queryWrapper));
    }
    @ApiOperation("未完成任务")
    @GetMapping("/uncompleted")
    public R listUncompleted() {
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Task::getCompleted, false)
                .orderByDesc(Task::getUpdateTime);
        return R.ok(taskService.list(queryWrapper));
    }

    @ApiOperation("星标任务")
    @GetMapping("/star")
    public R listStarTask() {
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Task::getStar, true)
                .orderByDesc(Task::getCreateTime);
        return R.ok(taskService.list(queryWrapper));
    }

    @ApiOperation("指定分组任务")
    @ApiImplicitParam(name = "分组id", required = true, dataTypeClass = Integer.class)
    @GetMapping("/group/{id}")
    public R listTaskByGroup(@NotNull @Min(0) @PathVariable("id") Integer id) {
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Task::getGroupId, id)
                .orderByAsc(Task::getCompleted)
                .orderByDesc(Task::getCreateTime);
        return R.ok(taskService.list(queryWrapper));
    }

    @ApiOperation("新建任务")
    @PostMapping
    public R addTask(@Validated @RequestBody AddTaskDto dto) {
        return R.ok(taskService.save(Task.builder().name(dto.getName()).groupId(dto.getGroupId()).build()));
    }

    @ApiOperation("标记任务完成")
    @PutMapping("/mark")
    public R markTask(@Validated @RequestBody MarkTaskDto dto) {
        LambdaUpdateWrapper<Task> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Task::getId, dto.getId())
                .set(Task::getCompleted, dto.getStatus());
        return R.ok(taskService.update(updateWrapper));
    }
    @ApiOperation("星标任务")
    @PutMapping("/star")
    public R starTask(@Validated @RequestBody MarkTaskDto dto) {
        LambdaUpdateWrapper<Task> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Task::getId, dto.getId())
                .set(Task::getStar, dto.getStatus());
        return R.ok(taskService.update(updateWrapper));
    }

    @ApiOperation("更新任务")
    @PutMapping
    public R updateTask(@Validated @RequestBody UpdateTaskDto dto) {
        Task task = Task.builder().build();
        BeanUtils.copyProperties(dto, task);
        return R.ok(taskService.updateById(task));
    }

    @ApiOperation("删除任务")
    @DeleteMapping("/{id}")
    public R deleteTask(@NotNull @Min(0) @PathVariable("id") Integer id) {
        return R.ok(taskService.removeById(id));
    }

    @ApiOperation("默认任务分类统计")
    @GetMapping("/analysisDefaultGroupTask")
    public R analysisDefaultGroupTask() {
        return R.ok(taskService.analysisDefaultGroupTask());
    }
}
