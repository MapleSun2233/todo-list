package com.example.todolist.service.impl;

import com.example.todolist.entity.Task;
import com.example.todolist.mapper.TaskMapper;
import com.example.todolist.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务表 服务实现类
 * </p>
 *
 * @author Maple
 * @since 2023-01-02
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}
