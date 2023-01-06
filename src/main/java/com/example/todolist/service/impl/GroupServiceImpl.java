package com.example.todolist.service.impl;

import com.example.todolist.entity.Group;
import com.example.todolist.mapper.GroupMapper;
import com.example.todolist.service.GroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.todolist.vo.GroupVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 分组表 服务实现类
 * </p>
 *
 * @author Maple
 * @since 2023-01-02
 */
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {
    @Override
    public List<GroupVo> listGroup() {
        return baseMapper.listGroup();
    }
}
