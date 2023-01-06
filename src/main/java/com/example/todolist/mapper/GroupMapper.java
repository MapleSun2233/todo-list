package com.example.todolist.mapper;

import com.example.todolist.entity.Group;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.todolist.vo.GroupVo;

import java.util.List;

/**
 * <p>
 * 分组表 Mapper 接口
 * </p>
 *
 * @author Maple
 * @since 2023-01-02
 */
public interface GroupMapper extends BaseMapper<Group> {
    /**
     * 分组信息
     * @return 分组信息
     */
    List<GroupVo> listGroup();
}
