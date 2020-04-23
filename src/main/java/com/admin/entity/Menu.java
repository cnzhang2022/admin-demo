package com.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
* @author tao on 2020-04-21 09:56:59
*/
@Data
@Accessors(chain = true)
public class Menu {

/**
* 主键
*/
@TableId(type = IdType.AUTO)
private Integer id;


    /**
    * 上级菜单
    */
    private Integer parentId;

    /**
    * 类型：1菜单 2权限
    */
    private Integer type;

    /**
    * 名称
    */
    private String name;

    /**
    * 链接
    */
    private String href;

    /**
    * 图标
    */
    private String icon;

    /**
    * 权限标识
    */
    private String permission;

}