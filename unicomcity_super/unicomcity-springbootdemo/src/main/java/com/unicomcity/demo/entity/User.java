package com.unicomcity.demo.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.unicomcity.common.validator.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;


/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 户用id
     */
    @TableField("userid")
    private Long userid;

    /**
     * 登录用户名
     */
    @NotNull(message = "登录用户名不能为空",groups = Query.class)
    @TableField("user_name")
    private String userName;

    /**
     * 登录密码
     */
    @TableField("pass_word")
    private String passWord;

    /**
     * 户用类型
     */
    @TableField("type")
    private Integer type;

    /**
     * 创建时间
     */
    @TableField("createtime")
    private LocalDateTime createtime;

    /**
     * 创建者
     */
    @TableField("createid")
    private Long createid;

    /**
     * 前端传来字段不做数据库操作
     * */
    @TableField(exist = false)
    private String usertype;
}
