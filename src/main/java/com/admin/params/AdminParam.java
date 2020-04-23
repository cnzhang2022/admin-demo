package com.admin.params;

import lombok.Data;
import lombok.experimental.Accessors;
    import java.util.Date;

/**
* @author tao on 2020-04-16 16:58:51
*/
@Data
@Accessors(chain = true)
public class AdminParam {

/**
* 主键
*/
private Integer id;

    /**
    * 登录名
    */
    private String loginname;

    /**
    * 手机号
    */
    private String telphone;

    /**
    * 邮箱
    */
    private String email;

    /**
    * 角色
    */
    private String role;

    /**
    * 审核状态
    */
    private Integer status;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 修改时间
    */
    private Date modifyTime;

}