package com.example.todolist.service;

import com.example.todolist.entity.Group;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.todolist.vo.GroupVo;

import java.util.List;

/**
 * <p>
 * 分组表 服务类
 * </p>
 *
 * @author Maple
 * @since 2023-01-02
 */
public interface GroupService extends IService<Group> {
    /**
     * 分组信息
     * @return 分组信息
     */
    List<GroupVo> listGroup();
}
