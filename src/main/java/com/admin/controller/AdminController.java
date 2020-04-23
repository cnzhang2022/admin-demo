package com.admin.controller;

import com.admin.entity.Admin;
import com.admin.params.AdminParam;
import com.admin.dto.AdminDto;
import com.admin.service.AdminService;
import com.tao.frameworks.admin.tools.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
* @author tao on 2020-04-16 16:58:51
*/
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @GetMapping(value = "/login", name = "登录")
    public String login() {
        return "token";
    }

    @PostMapping(value = "/insert", name = "插入")
    public void insert(Admin admin) {
        this.adminService.insert(admin);
    }

    @GetMapping(value = "/delete", name = "删除")
    public void delete(Integer id) {
        this.adminService.deleteById(id);
    }

    @PostMapping(value = "/update", name = "修改")
    public void update(Admin admin) {
        this.adminService.update(admin);
    }

    @GetMapping(value = "/get", name = "详情")
    public AdminDto get(Integer id) {
        return this.adminService.getById(id);
    }

    @PostMapping(value = "/query", name = "分页查询")
    public Result query(int page, int limit, AdminParam params) {
        return this.adminService.selectPage(page, limit, params);
    }

    @PostMapping(value = "/select", name = "查询所有")
    public List<Admin> select(AdminParam params) {
        return this.adminService.selectByMap(params);
    }

}