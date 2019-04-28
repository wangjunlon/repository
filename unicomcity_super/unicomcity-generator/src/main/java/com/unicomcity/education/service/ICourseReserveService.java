package com.unicomcity.education.service;

import com.unicomcity.education.entity.CourseReserve;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王军龙
 * @since 2019-04-23
 */
public interface ICourseReserveService {
    public String queryListCourseReserve(String json);
    public String insertCourseReserve(String json);
    public String updateCourseReserve(String json);
    public String deleteCourseReserve(String json);
}
