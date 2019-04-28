package com.unicomcity.education.service;

import com.unicomcity.education.entity.CourseTask;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王军龙
 * @since 2019-04-23
 */
public interface ICourseTaskService {
    public String queryListCourseTask(String json);
    public String insertCourseTask(String json);
    public String updateCourseTask(String json);
    public String deleteCourseTask(String json);
}
