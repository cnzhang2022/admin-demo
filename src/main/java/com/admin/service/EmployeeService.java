package com.admin.service;

import org.springframework.stereotype.Service;
import com.admin.dao.EmployeeMapper;
import com.admin.entity.Employee;
import com.admin.dto.EmployeeDto;
import com.admin.params.EmployeeParam;
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
 * @author tao on 2020-04-20 11:16:31
 */
@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 插入
     *
     * @param employee 实体对象
     */
    public int insert(Employee employee){
        return employeeMapper.insert(employee);
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    public int deleteById(Integer id){
        return employeeMapper.deleteById(id);
    }

    /**
     * 修改
     *
     * @param employee 实体对象
     */
    public int update(Employee employee){
        return employeeMapper.updateById(employee);
    }

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     * @return
     */
    public EmployeeDto getById(Integer id){
        Employee employee = employeeMapper.selectById(id);
        if(employee!=null){
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employee, employeeDto);
            return employeeDto;
        }
        return null;
    }

    /**
     * 条件查询所有
     *
     * @param param
     * @return
     */
    public List<EmployeeDto> selectByMap(EmployeeParam param) {
        Map<String, Object> columnMap = MapUtils.beanToMap(param);
        List<Employee> employeeList = employeeMapper.selectByMap(columnMap);
        List<EmployeeDto> employeeDtoList = employeeList.stream().map(employee -> {
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employee, employeeDto);
            return employeeDto;
        }).collect(Collectors.toList());
        return employeeDtoList;
    }

    /**
     * 条件查询并分页
     *
     * @param page
     * @param limit
     * @param param
     * @return
     */
    public Result selectPage(int page, int limit, EmployeeParam param) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        Map<String, Object> columnMap = MapUtils.beanToMap(param);
        if(columnMap!=null) {
            columnMap.entrySet().forEach(entry -> queryWrapper.eq(entry.getKey(), entry.getValue()));
        }
        IPage<Employee> p = new Page<>(page, limit);
        IPage<Employee> ipage = employeeMapper.selectPage(p, queryWrapper);
        List<Employee> employeeList = ipage.getRecords();
        List<EmployeeDto> employeeDtoList = employeeList.stream().map(employee -> {
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employee, employeeDto);
            return employeeDto;
        }).collect(Collectors.toList());
        int total = (int)ipage.getTotal();
        Result result = new Result();
        result.setData(employeeDtoList);
        result.setCount(total);
        return result;
    }

}