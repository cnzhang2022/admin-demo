package com.admin.service;

import org.springframework.stereotype.Service;
import com.admin.dao.RoleUserMapper;
import com.admin.entity.RoleUser;
import com.admin.dto.RoleUserDto;
import com.admin.params.RoleUserParam;
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
 * @author tao on 2020-04-29 16:36:09
 */
@Service
public class RoleUserService {

    @Resource
    private RoleUserMapper roleUserMapper;

    /**
     * 插入
     *
     * @param roleUser 实体对象
     */
    public int insert(RoleUser roleUser){
        return roleUserMapper.insert(roleUser);
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    public int deleteById(Integer id){
        return roleUserMapper.deleteById(id);
    }

    /**
     * 修改
     *
     * @param roleUser 实体对象
     */
    public int update(RoleUser roleUser){
        return roleUserMapper.updateById(roleUser);
    }

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     * @return
     */
    public RoleUserDto getById(Integer id){
        RoleUser roleUser = roleUserMapper.selectById(id);
        if(roleUser!=null){
            RoleUserDto roleUserDto = new RoleUserDto();
            BeanUtils.copyProperties(roleUser, roleUserDto);
            return roleUserDto;
        }
        return null;
    }

    /**
     * 条件查询所有
     *
     * @param param
     * @return
     */
    public List<RoleUserDto> selectByMap(RoleUserParam param) {
        Map<String, Object> columnMap = MapUtils.beanToMap(param);
        List<RoleUser> roleUserList = roleUserMapper.selectByMap(columnMap);
        List<RoleUserDto> roleUserDtoList = roleUserList.stream().map(roleUser -> {
            RoleUserDto roleUserDto = new RoleUserDto();
            BeanUtils.copyProperties(roleUser, roleUserDto);
            return roleUserDto;
        }).collect(Collectors.toList());
        return roleUserDtoList;
    }

    /**
     * 条件查询并分页
     *
     * @param page
     * @param limit
     * @param param
     * @return
     */
    public Result selectPage(int page, int limit, RoleUserParam param) {
        QueryWrapper<RoleUser> queryWrapper = new QueryWrapper<>();
        Map<String, Object> columnMap = MapUtils.beanToMap(param);
        if(columnMap!=null) {
            columnMap.entrySet().forEach(entry -> queryWrapper.eq(entry.getKey(), entry.getValue()));
        }
        IPage<RoleUser> p = new Page<>(page, limit);
        IPage<RoleUser> ipage = roleUserMapper.selectPage(p, queryWrapper);
        List<RoleUser> roleUserList = ipage.getRecords();
        List<RoleUserDto> roleUserDtoList = roleUserList.stream().map(roleUser -> {
            RoleUserDto roleUserDto = new RoleUserDto();
            BeanUtils.copyProperties(roleUser, roleUserDto);
            return roleUserDto;
        }).collect(Collectors.toList());
        int total = (int)ipage.getTotal();
        Result result = new Result();
        result.setData(roleUserDtoList);
        result.setCount(total);
        return result;
    }

    public void insertBatch(Integer rid, String uids){
        String [] uidArry = uids.split(",");
        for (int i = 0; i < uidArry.length; i++) {
            RoleUser roleUser = new RoleUser();
            roleUser.setRid(rid);
            roleUser.setUid(Integer.valueOf(uidArry[i]));
            insert(roleUser);
        }
    }

    public void deleteCancel(Integer rid, Integer uid){
        roleUserMapper.deleteCancel(rid, uid);
    }

}