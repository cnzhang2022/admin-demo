package com.admin.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
* @author tao on 2020-04-16 16:58:51
*/
@Data
@Accessors(chain = true)
public class RoleUserParam {

    /**
    * 角色ID
    */
    private Integer roleId;

    /**
    * 登录名称
    */
    private String loginname;

    /**
    * 手机号码
    */
    private String telphone;

}