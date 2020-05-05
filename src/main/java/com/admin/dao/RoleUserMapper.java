package com.admin.dao;

import com.admin.entity.RoleUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tao on 2020-04-29 16:36:09
 */
public interface RoleUserMapper extends BaseMapper<RoleUser> {

    void deleteCancel(@Param("rid")Integer rid, @Param("uid")Integer uid);
}