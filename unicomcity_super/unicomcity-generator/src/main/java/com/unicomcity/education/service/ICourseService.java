package com.unicomcity.education.service;

import com.unicomcity.education.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王军龙
 * @since 2019-04-23
 */
public interface ICourseService {
    public String queryListCourse(String json);
    public String insertCourse(String json);
    public String updateCourse(String json);
    public String deleteCourse(String json);
}
