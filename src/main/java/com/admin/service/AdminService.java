package com.admin.service;

import com.tao.frameworks.admin.tools.Result;
import org.springframework.stereotype.Service;
import com.admin.dao.AdminMapper;
import com.admin.entity.Admin;
import com.admin.dto.AdminDto;
import com.admin.params.AdminParam;
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
 * @author tao on 2020-04-16 16:58:51
 */
@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    /**
     * 插入
     *
     * @param admin 实体对象
     */
    public int insert(Admin admin){
        return adminMapper.insert(admin);
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    public int deleteById(Integer id){
        return adminMapper.deleteById(id);
    }

    /**
     * 修改
     *
     * @param admin 实体对象
     */
    public int update(Admin admin){
        return adminMapper.updateById(admin);
    }

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     * @return
     */
    public AdminDto getById(Integer id){
        Admin admin = adminMapper.selectById(id);
        if(admin!=null){
            AdminDto adminDto = new AdminDto();
            BeanUtils.copyProperties(admin, adminDto);
            return adminDto;
        }
        return null;
    }

    /**
     * 条件查询所有
     *
     * @param param
     * @return
     */
    public List<Admin> selectByMap(AdminParam param) {
        Map<String, Object> columnMap = MapUtils.beanToMap(param);
        return adminMapper.selectByMap(columnMap);
    }

    /**
     * 条件查询并分页
     *
     * @param page
     * @param limit
     * @param param
     * @return
     */
    public Result selectPage(int page, int limit, AdminParam param) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        Map<String, Object> columnMap = MapUtils.beanToMap(param);
        if(columnMap!=null) {
            columnMap.entrySet().forEach(entry -> queryWrapper.eq(entry.getKey(), entry.getValue()));
        }
        IPage<Admin> p = new Page<>(page, limit);
        IPage<Admin> ipage = adminMapper.selectPage(p, queryWrapper);
        List<Admin> adminList = ipage.getRecords();
        List<AdminDto> adminDtoList = adminList.stream().map(admin -> {
            AdminDto adminDto = new AdminDto();
            BeanUtils.copyProperties(admin, adminDto);
            return adminDto;
        }).collect(Collectors.toList());

        int total = (int)ipage.getTotal();
        Result result = new Result();
        result.setData(adminDtoList);
        result.setCount(total);
        return result;
    }

}