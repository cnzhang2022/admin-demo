package com.admin.params;

import lombok.Data;
import lombok.experimental.Accessors;

/**
* @author tao on 2020-04-20 10:59:26
*/
@Data
@Accessors(chain = true)
public class EmployeeParam {

/**
* 主键
*/
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