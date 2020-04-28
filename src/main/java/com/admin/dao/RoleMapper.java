package com.admin.dao;

import com.admin.dto.RoleUserDto;
import com.admin.entity.Role;
import com.admin.params.RoleUserParam;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;

/**
 * @author tao on 2020-04-18 14:36:46
 */
public interface RoleMapper extends BaseMapper<Role> {

    IPage<RoleUserDto> selectAllocatedUser(IPage<RoleUserDto> page, @Param(Constants.WRAPPER) Wrapper<RoleUserParam> queryWrapper);

    IPage<RoleUserDto> selectUnallocatedUser(IPage<RoleUserDto> page, @Param("param") RoleUserParam param);

}