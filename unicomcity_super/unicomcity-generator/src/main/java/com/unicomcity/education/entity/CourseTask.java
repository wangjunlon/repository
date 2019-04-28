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
public class CourseTask implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 任务名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 任务类型默认：0（一期暂做普通排课

）
            0.普通排课
            1.走班排课
            2.3+1排课
     */
    @TableField("type_id")
    private Integer typeId;

    /**
     * 任务状态默认：0
            0.未排课
            1.排课中
            2.已完成
            3.排课失败
            
     */
    @TableField("state")
    private Integer state;

    /**
     * 学校id
     */
    @TableField("schid")
    private Integer schid;

    /**
     * 学校简称
     */
    @TableField("sch_sname")
    private String schSname;

    /**
     * 数据创建时间
     */
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 数据更新时间
     */
    @TableField("gmt_modified")
    private LocalDateTime gmtModified;

    /**
     * 由谁创建
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 由谁更新
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 是否删除 默认:0
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
