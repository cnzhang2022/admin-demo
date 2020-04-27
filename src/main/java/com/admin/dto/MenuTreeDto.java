package com.admin.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
* @author tao on 2020-04-21 09:56:59
*/
@Data
@Accessors(chain = true)
public class MenuTreeDto {

    /**
    * 主键
    */
    private Integer id;

    /**
    * 名称
    */
    private String title;

    /**
     * 展开
     */
    private boolean spread;

    /**
     * 子节点
     */
    private List<MenuTreeDto> children;
}