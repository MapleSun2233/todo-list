package com.example.todolist.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.todolist.common.R;
import com.example.todolist.entity.Group;
import com.example.todolist.entity.Task;
import com.example.todolist.service.GroupService;
import com.example.todolist.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * <p>
 * 分组表 前端控制器
 * </p>
 *
 * @author Maple
 * @since 2023-01-02
 */
@RestController
@RequestMapping("/group")
@Api(tags = "分组管理")
public class GroupController {
    @Resource
    private GroupService groupService;
    @Resource
    private TaskService taskService;

    @ApiOperation("增加分组")
    @ApiImplicitParam(required = true, value = "name", name = "分组名", dataTypeClass = String.class)
    @PostMapping("/{name}")
    public R add(@Null @NotEmpty @PathVariable("name") String name) {
        return groupService.save(Group.builder()
                .name(name).build())
                ? R.ok() : R.fail();
    }

    @ApiOperation("修改分组")
    @PutMapping
    public R update(@Validated @RequestBody Group dto) {
        return groupService.updateById(dto) ? R.ok() : R.fail();
    }

    @ApiOperation("删除分组")
    @ApiImplicitParam(name = "id", dataTypeClass = Integer.class, required = true)
    @DeleteMapping("/{id}")
    public R delete(@NotNull @Min(0) @PathVariable("id") Integer id) {
        LambdaQueryWrapper<Task> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Task::getGroupId, id);
        taskService.remove(queryWrapper);
        return groupService.removeById(id) ? R.ok() : R.fail();
    }

    @ApiOperation("获取分组")
    @GetMapping
    public R list() {
        return R.ok(groupService.listGroup());
    }
}
