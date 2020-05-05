package com.admin.controller;

import com.admin.entity.Role;
import com.admin.params.RoleParam;
import com.admin.dto.RoleDto;
import com.admin.params.RoleUserParam;
import com.admin.service.RoleService;
import com.admin.service.RoleUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import com.tao.frameworks.admin.tools.Result;

/**
* @author tao on 2020-04-18 14:52:25
*/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;
    @Resource
    private RoleUserService roleUserService;

    @PostMapping(value = "/insert", name = "插入")
    public void insert(Role role) {
        this.roleService.insert(role);
    }

    @GetMapping(value = "/delete", name = "删除")
    public void delete(Integer id) {
        this.roleService.deleteById(id);
    }

    @PostMapping(value = "/update", name = "修改")
    public void update(Role role) {
        this.roleService.update(role);
    }

    @GetMapping(value = "/get", name = "详情")
    public RoleDto get(Integer id) {
        return this.roleService.getById(id);
    }

    @PostMapping(value = "/query", name = "分页查询")
    public Result query(int page, int limit, RoleParam params) {
        return this.roleService.selectPage(page, limit, params);
    }

    @PostMapping(value = "/select", name = "查询所有")
    public List<Role> select(RoleParam params) {
        return this.roleService.selectByMap(params);
    }

    @PostMapping(value = "/authUser/allocatedList", name = "")
    public Result authUserList(int page, int limit, RoleUserParam params) {
        return this.roleService.selectAllocatedUser(page, limit, params);
    }

    @PostMapping(value = "/authUser/unallocatedList", name = "")
    public Result unallocatedList(int page, int limit, RoleUserParam params) {
        return this.roleService.selectUnallocatedUser(page, limit, params);
    }

    @RequestMapping(value = "/authUser/saveSelectAll", name = "")
    public void saveSelectAll(Integer rid, String uids) {
        roleUserService.insertBatch(rid, uids);
    }

    @RequestMapping(value = "/authUser/cancel", name = "")
    public void deleteCancel(Integer rid, Integer uid) {
        roleUserService.deleteCancel(rid, uid);
    }
}