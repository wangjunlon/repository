package com.unicomcity.demo.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 用户基础信息
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 流水id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 户用id
     */
    @TableField("userid")
    private Long userid;

    /**
     * 户用登录ip
     */
    @TableField("host")
    private String host;

    /**
     * 真实姓名
     */
    @TableField("name")
    private String name;

    /**
     * 份证身号码
     */
    @TableField("id_crad")
    private String idCrad;

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

}
