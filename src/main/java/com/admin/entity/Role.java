package com.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;
    import java.util.Date;

/**
* @author tao on 2020-04-18 14:52:25
*/
@Data
@Accessors(chain = true)
public class Role {

/**
* 主键
*/
@TableId(type = IdType.AUTO)
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