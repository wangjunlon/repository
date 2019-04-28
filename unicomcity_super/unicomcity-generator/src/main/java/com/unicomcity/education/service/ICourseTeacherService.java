package com.unicomcity.education.service;

import com.unicomcity.education.entity.CourseTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王军龙
 * @since 2019-04-23
 */
public interface ICourseTeacherService {
    public String queryListCourseTeacher(String json);
    public String insertCourseTeacher(String json);
    public String updateCourseTeacher(String json);
    public String deleteCourseTeacher(String json);
}
