package com.admin.controller;

import com.admin.entity.Employee;
import com.admin.params.EmployeeParam;
import com.admin.dto.EmployeeDto;
import com.admin.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import com.tao.frameworks.admin.tools.Result;

/**
* @author tao on 2020-04-20 11:16:31
*/
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @PostMapping(value = "/insert", name = "插入")
    public void insert(Employee employee) {
        this.employeeService.insert(employee);
    }

    @GetMapping(value = "/delete", name = "删除")
    public void delete(Integer id) {
        this.employeeService.deleteById(id);
    }

    @PostMapping(value = "/update", name = "修改")
    public void update(Employee employee) {
        this.employeeService.update(employee);
    }

    @GetMapping(value = "/get", name = "详情")
    public EmployeeDto get(Integer id) {
        return this.employeeService.getById(id);
    }

    @PostMapping(value = "/query", name = "分页查询")
    public Result query(int page, int limit, EmployeeParam params) {
        return this.employeeService.selectPage(page, limit, params);
    }

    @PostMapping(value = "/select", name = "查询所有")
    public List<EmployeeDto> select(EmployeeParam params) {
        return this.employeeService.selectByMap(params);
    }

}