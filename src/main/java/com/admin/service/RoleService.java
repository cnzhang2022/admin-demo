package com.admin.service;

import org.springframework.stereotype.Service;
import com.admin.dao.RoleMapper;
import com.admin.entity.Role;
import com.admin.dto.RoleDto;
import com.admin.params.RoleParam;
import com.tao.frameworks.admin.tools.Result;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tao.frameworks.admin.tools.MapUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;

/**
 * @author tao on 2020-04-18 14:52:25
 */
@Service
public class RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 插入
     *
     * @param role 实体对象
     */
    public int insert(Role role){
        return roleMapper.insert(role);
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    public int deleteById(Integer id){
        return roleMapper.deleteById(id);
    }

    /**
     * 修改
     *
     * @param role 实体对象
     */
    public int update(Role role){
        return roleMapper.updateById(role);
    }

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     * @return
     */
    public RoleDto getById(Integer id){
        Role role = roleMapper.selectById(id);
        if(role!=null){
            RoleDto roleDto = new RoleDto();
            BeanUtils.copyProperties(role, roleDto);
            return roleDto;
        }
        return null;
    }

    /**
     * 条件查询所有
     *
     * @param param
     * @return
     */
    public List<Role> selectByMap(RoleParam param) {
        Map<String, Object> columnMap = MapUtils.beanToMap(param);
        return roleMapper.selectByMap(columnMap);
    }

    /**
     * 条件查询并分页
     *
     * @param page
     * @param limit
     * @param param
     * @return
     */
    public Result selectPage(int page, int limit, RoleParam param) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        Map<String, Object> columnMap = MapUtils.beanToMap(param);
        if(columnMap!=null) {
            columnMap.entrySet().forEach(entry -> queryWrapper.eq(entry.getKey(), entry.getValue()));
        }
        IPage<Role> p = new Page<>(page, limit);
        IPage<Role> ipage = roleMapper.selectPage(p, queryWrapper);
        List<Role> roleList = ipage.getRecords();
        List<RoleDto> roleDtoList = roleList.stream().map(role -> {
            RoleDto roleDto = new RoleDto();
            BeanUtils.copyProperties(role, roleDto);
            return roleDto;
        }).collect(Collectors.toList());
        int total = (int)ipage.getTotal();
        Result result = new Result();
        result.setData(roleDtoList);
        result.setCount(total);
        return result;
    }

}