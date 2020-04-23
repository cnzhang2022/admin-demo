package com.admin.controller;

import com.admin.entity.Menu;
import com.admin.params.MenuParam;
import com.admin.dto.MenuDto;
import com.admin.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import com.tao.frameworks.admin.tools.Result;

/**
* @author tao on 2020-04-21 09:56:59
*/
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @PostMapping(value = "/insert", name = "插入")
    public void insert(Menu menu) {
        this.menuService.insert(menu);
    }

    @GetMapping(value = "/delete", name = "删除")
    public void delete(Integer id) {
        this.menuService.deleteById(id);
    }

    @PostMapping(value = "/update", name = "修改")
    public void update(Menu menu) {
        this.menuService.update(menu);
    }

    @GetMapping(value = "/get", name = "详情")
    public MenuDto get(Integer id) {
        return this.menuService.getById(id);
    }

    @PostMapping(value = "/query", name = "分页查询")
    public Result query(int page, int limit, MenuParam params) {
        return this.menuService.selectPage(page, limit, params);
    }

    @PostMapping(value = "/select", name = "查询所有")
    public List<MenuDto> select(MenuParam params) {
        return this.menuService.selectByMap(params);
    }

}