package com.unicomcity.education.service;

import com.unicomcity.education.entity.CourseBase;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王军龙
 * @since 2019-04-23
 */
public interface ICourseBaseService {
    public String queryListCourseBase(String json);
    public String insertCourseBase(String json);
    public String updateCourseBase(String json);
    public String deleteCourseBase(String json);
}
