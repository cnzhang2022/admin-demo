package com.admin.service;

import org.springframework.stereotype.Service;
import com.admin.dao.MenuMapper;
import com.admin.entity.Menu;
import com.admin.dto.MenuDto;
import com.admin.params.MenuParam;
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
 * @author tao on 2020-04-21 09:56:59
 */
@Service
public class MenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 插入
     *
     * @param menu 实体对象
     */
    public int insert(Menu menu){
        return menuMapper.insert(menu);
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    public int deleteById(Integer id){
        return menuMapper.deleteById(id);
    }

    /**
     * 修改
     *
     * @param menu 实体对象
     */
    public int update(Menu menu){
        return menuMapper.updateById(menu);
    }

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     * @return
     */
    public MenuDto getById(Integer id){
        Menu menu = menuMapper.selectById(id);
        if(menu!=null){
            MenuDto menuDto = new MenuDto();
            BeanUtils.copyProperties(menu, menuDto);
            return menuDto;
        }
        return null;
    }

    /**
     * 条件查询所有
     *
     * @param param
     * @return
     */
    public List<MenuDto> selectByMap(MenuParam param) {
        Map<String, Object> columnMap = MapUtils.beanToMap(param);
        List<Menu> menuList = menuMapper.selectByMap(columnMap);
        List<MenuDto> menuDtoList = menuList.stream().map(menu -> {
            MenuDto menuDto = new MenuDto();
            BeanUtils.copyProperties(menu, menuDto);
            return menuDto;
        }).collect(Collectors.toList());
        return menuDtoList;
    }

    /**
     * 条件查询并分页
     *
     * @param page
     * @param limit
     * @param param
     * @return
     */
    public Result selectPage(int page, int limit, MenuParam param) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        Map<String, Object> columnMap = MapUtils.beanToMap(param);
        if(columnMap!=null) {
            columnMap.entrySet().forEach(entry -> queryWrapper.eq(entry.getKey(), entry.getValue()));
        }
        IPage<Menu> p = new Page<>(page, limit);
        IPage<Menu> ipage = menuMapper.selectPage(p, queryWrapper);
        List<Menu> menuList = ipage.getRecords();
        List<MenuDto> menuDtoList = menuList.stream().map(menu -> {
            MenuDto menuDto = new MenuDto();
            BeanUtils.copyProperties(menu, menuDto);
            return menuDto;
        }).collect(Collectors.toList());
        int total = (int)ipage.getTotal();
        Result result = new Result();
        result.setData(menuDtoList);
        result.setCount(total);
        return result;
    }

}