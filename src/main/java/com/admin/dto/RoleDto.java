package com.admin.dto;

import lombok.Data;
import lombok.experimental.Accessors;
    import java.util.Date;

/**
* @author tao on 2020-04-18 14:36:46
*/
@Data
@Accessors(chain = true)
public class RoleDto {

/**
* 主键
*/
private Integer id;

    /**
    * 名称
    */
    private String name;

    /**
    * 类型
    */
    private Integer type;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 修改时间
    */
    private Date modifyTime;

}