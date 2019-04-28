package com.unicomcity.education.entity;
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
 * 
 * </p>
 *
 * @author 王军龙
 * @since 2019-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseBase implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 任务id
     */
    @TableField("cur_id")
    private Integer curId;

    /**
     * 每周上课天数，最多7天
            1.1天
            2.2天
            3.3天
            4.4天
            5.5天
            6.6天
            7.7天
            
     */
    @TableField("week_count")
    private Integer weekCount;

    /**
     * 上午上几节课，最多5节
            1.1节
            2.2节
            3.3节
            4.4节
            5.5节
     */
    @TableField("am_count")
    private Integer amCount;

    /**
     * 下午上几节课，最多5节
            1.1节
            2.2节
            3.3节
            4.4节
            5.5节
     */
    @TableField("pm_count")
    private Integer pmCount;

    /**
     * 晚上上几节课，最多3节
            1.1节
            2.2节
            3.3节
     */
    @TableField("nt_count")
    private Integer ntCount;

    /**
     * 数据创建时间
     */
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 由谁创建
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 默认:1
            0.否
            1.是
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    /**
     * 备用
     */
    @TableField("backup_a")
    private String backupA;

    /**
     * 备用
     */
    @TableField("backup_b")
    private String backupB;

}
