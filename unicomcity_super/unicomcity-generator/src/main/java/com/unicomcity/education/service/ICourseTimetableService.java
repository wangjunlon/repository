package com.unicomcity.education.service;

import com.unicomcity.education.entity.CourseTimetable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王军龙
 * @since 2019-04-23
 */
public interface ICourseTimetableService {
    public String queryListCourseTimetable(String json);
    public String insertCourseTimetable(String json);
    public String updateCourseTimetable(String json);
    public String deleteCourseTimetable(String json);
}
