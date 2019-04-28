package com.unicomcity.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.unicomcity.common.validator.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


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
public class UserAndUserinfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 流水号
     */
    private Long id;

    /**
     * 户用id
     */
    private Long userid;

    /**
     * 登录用户名
     */
    private String userName;

    /**
     * 登录密码
     */
    private String passWord;

    /**
     * 户用类型
     */
    private Integer type;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createtime;

    /**
     * 创建者
     */
    private Long createid;

    /**
     * 用户登录ip
     */
    private String host;

    /**
     * 真实姓名
     */
    private String name;

    /**
     * 份证身号码
     */
    private String idCrad;

}