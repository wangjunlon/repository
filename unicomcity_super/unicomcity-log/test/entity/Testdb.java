package test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 测试数据库
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Testdb implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 流水id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 户用名
     */
    @TableField("username")
    private String username;

}
