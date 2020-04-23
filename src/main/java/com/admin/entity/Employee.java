package com.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
* @author tao on 2020-04-20 11:57:47
*/
@Data
@Accessors(chain = true)
public class Employee {

/**
* 主键
*/
@TableId(type = IdType.AUTO)
private Integer id;


    /**
    * 姓名
    */
    private String name;

    /**
    * 年龄
    */
    private Integer age;

    /**
    * 地址
    */
    private String address;

}