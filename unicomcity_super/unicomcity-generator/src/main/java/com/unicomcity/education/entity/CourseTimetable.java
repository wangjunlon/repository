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
public class CourseTimetable implements Serializable {
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
     * 年级id
     */
    @TableField("grade_id")
    private Integer gradeId;

    /**
     * 年级简称
     */
    @TableField("grade_name")
    private String gradeName;

    /**
     * 班级id
     */
    @TableField("clazz_id")
    private Integer clazzId;

    /**
     * 班级名称
     */
    @TableField("clazz_sname")
    private String clazzSname;

    /**
     * 星期
     */
    @TableField("WEEK")
    private Integer week;

    /**
     * 课节
     */
    @TableField("sequence")
    private Integer sequence;

    /**
     * 课程id
     */
    @TableField("course_id")
    private Integer courseId;

    /**
     * 课程名称
     */
    @TableField("course_name")
    private String courseName;

    /**
     * 教师id
     */
    @TableField("teacher_id")
    private Integer teacherId;

    /**
     * 教师名称
     */
    @TableField("teacher_name")
    private String teacherName;

    /**
     * 由谁创建
     */
    @TableField("create_by")
    private String createBy;

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
     * 由谁更新
     */
    @TableField("update_by")
    private String updateBy;

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
