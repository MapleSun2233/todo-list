package com.example.todolist.service.impl;

import com.example.todolist.entity.Task;
import com.example.todolist.mapper.TaskMapper;
import com.example.todolist.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.todolist.vo.DefaultGroupTaskCountVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DefaultGroupTaskCountVo analysisDefaultGroupTask() {
        return baseMapper.analysisDefaultGroupTask();
    }
}
