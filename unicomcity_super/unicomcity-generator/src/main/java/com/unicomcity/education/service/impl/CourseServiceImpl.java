package com.unicomcity.education.service.impl;

import com.unicomcity.education.entity.Course;
import com.unicomcity.education.mapper.CourseMapper;
import com.unicomcity.education.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.unicomcity.common.controller.MessageObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.unicomcity.common.controller.MessageUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王军龙
 * @since 2019-04-23
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
            @Autowired
            private CourseMapper courseMapper;
             public String queryListCourse(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, Course.class);
                    Course  _course_querylist = (Course) messageObject.getContent();
                    QueryWrapper<Course> _course_querylist_wrapper = new QueryWrapper<>();
                    _course_querylist_wrapper.eq("id",_course_querylist.getId());
                    _course_querylist_wrapper.eq("course_name",_course_querylist.getCourseName());
                    _course_querylist_wrapper.eq("course_code",_course_querylist.getCourseCode());
                    _course_querylist_wrapper.eq("course_type",_course_querylist.getCourseType());
                    Page<Course> _course_querylist_page = new Page<>(messageObject.getPagesize(),messageObject.getCurrent());
                    IPage<Course> _course_query_ipage = this.page(_course_querylist_page,_course_querylist_wrapper);
                    messageObject.setCode("1000");
                    messageObject.setPages(_course_query_ipage.getTotal());
                    messageObject.setContent(_course_querylist_page.getRecords());
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String insertCourse(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, Course.class);
                     Course _course_insert = ( Course) messageObject.getContent();
                    int _course_insert_rep =  courseMapper.insert(_course_insert);
                    if(_course_insert_rep>0){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String updateCourse(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json,Course.class);
                    Course _course_update = (  Course) messageObject.getContent();
                    UpdateWrapper _course_update_wrapper = new UpdateWrapper();
                     _course_update_wrapper.eq("id",_course_update.getId());
                    boolean _course_update_rep =  this.update(_course_update_wrapper);
                    if(_course_update_rep){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String deleteCourse(String json){
                     MessageObject messageObject =  MessageUtils.ObectToClass(json,Course.class);
                     Course _course_delete = (Course) messageObject.getContent();
                     QueryWrapper _course_delete_wrapper = new QueryWrapper();
                     _course_delete_wrapper.eq("id",_course_delete.getId());
                     boolean _course_delete_rep =  this.remove(_course_delete_wrapper);
                     if(_course_delete_rep){
                         messageObject.setCode("1000");
                         messageObject.setContent("您新增成功");
                     }
                     return MessageUtils.ObjectTojson(messageObject);
             }
}
