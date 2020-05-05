package com.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
* @author tao on 2020-04-29 16:36:09
*/
@Data
@Accessors(chain = true)
public class RoleUser {

/**
* 主键
*/
@TableId(type = IdType.AUTO)
private Integer id;


    /**
    * 
    */
    private Integer rid;

    /**
    * 
    */
    private Integer uid;

}