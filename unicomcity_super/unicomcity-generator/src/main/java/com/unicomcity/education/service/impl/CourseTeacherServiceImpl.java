package com.unicomcity.education.service.impl;

import com.unicomcity.education.entity.CourseTeacher;
import com.unicomcity.education.mapper.CourseTeacherMapper;
import com.unicomcity.education.service.ICourseTeacherService;
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
public class CourseTeacherServiceImpl extends ServiceImpl<CourseTeacherMapper, CourseTeacher> implements ICourseTeacherService {
            @Autowired
            private CourseTeacherMapper course_teacherMapper;
             public String queryListCourseTeacher(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, CourseTeacher.class);
                    CourseTeacher  _course_teacher_querylist = (CourseTeacher) messageObject.getContent();
                    QueryWrapper<CourseTeacher> _course_teacher_querylist_wrapper = new QueryWrapper<>();
                    _course_teacher_querylist_wrapper.eq("id",_course_teacher_querylist.getId());
                    _course_teacher_querylist_wrapper.eq("cur_id",_course_teacher_querylist.getCurId());
                    _course_teacher_querylist_wrapper.eq("grade_id",_course_teacher_querylist.getGradeId());
                    _course_teacher_querylist_wrapper.eq("grade_name",_course_teacher_querylist.getGradeName());
                    _course_teacher_querylist_wrapper.eq("clazz_id",_course_teacher_querylist.getClazzId());
                    _course_teacher_querylist_wrapper.eq("clazz_sname",_course_teacher_querylist.getClazzSname());
                    _course_teacher_querylist_wrapper.eq("period",_course_teacher_querylist.getPeriod());
                    _course_teacher_querylist_wrapper.eq("course_id",_course_teacher_querylist.getCourseId());
                    _course_teacher_querylist_wrapper.eq("course_name",_course_teacher_querylist.getCourseName());
                    _course_teacher_querylist_wrapper.eq("teacher_id",_course_teacher_querylist.getTeacherId());
                    _course_teacher_querylist_wrapper.eq("teacher_name",_course_teacher_querylist.getTeacherName());
                    _course_teacher_querylist_wrapper.eq("create_by",_course_teacher_querylist.getCreateBy());
                    _course_teacher_querylist_wrapper.eq("gmt_create",_course_teacher_querylist.getGmtCreate());
                    _course_teacher_querylist_wrapper.eq("update_by",_course_teacher_querylist.getUpdateBy());
                    _course_teacher_querylist_wrapper.eq("gmt_update",_course_teacher_querylist.getGmtUpdate());
                    _course_teacher_querylist_wrapper.eq("is_deleted",_course_teacher_querylist.getIsDeleted());
                    _course_teacher_querylist_wrapper.eq("backup_a",_course_teacher_querylist.getBackupA());
                    _course_teacher_querylist_wrapper.eq("backup_b",_course_teacher_querylist.getBackupB());
                    Page<CourseTeacher> _course_teacher_querylist_page = new Page<>(messageObject.getPagesize(),messageObject.getCurrent());
                    IPage<CourseTeacher> _course_teacher_query_ipage = this.page(_course_teacher_querylist_page,_course_teacher_querylist_wrapper);
                    messageObject.setCode("1000");
                    messageObject.setPages(_course_teacher_query_ipage.getTotal());
                    messageObject.setContent(_course_teacher_querylist_page.getRecords());
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String insertCourseTeacher(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, CourseTeacher.class);
                     CourseTeacher _course_teacher_insert = ( CourseTeacher) messageObject.getContent();
                    int _course_teacher_insert_rep =  course_teacherMapper.insert(_course_teacher_insert);
                    if(_course_teacher_insert_rep>0){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String updateCourseTeacher(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json,CourseTeacher.class);
                    CourseTeacher _course_teacher_update = (  CourseTeacher) messageObject.getContent();
                    UpdateWrapper _course_teacher_update_wrapper = new UpdateWrapper();
                     _course_teacher_update_wrapper.eq("id",_course_teacher_update.getId());
                    boolean _course_teacher_update_rep =  this.update(_course_teacher_update_wrapper);
                    if(_course_teacher_update_rep){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String deleteCourseTeacher(String json){
                     MessageObject messageObject =  MessageUtils.ObectToClass(json,CourseTeacher.class);
                     CourseTeacher _course_teacher_delete = (CourseTeacher) messageObject.getContent();
                     QueryWrapper _course_teacher_delete_wrapper = new QueryWrapper();
                     _course_teacher_delete_wrapper.eq("id",_course_teacher_delete.getId());
                     boolean _course_teacher_delete_rep =  this.remove(_course_teacher_delete_wrapper);
                     if(_course_teacher_delete_rep){
                         messageObject.setCode("1000");
                         messageObject.setContent("您新增成功");
                     }
                     return MessageUtils.ObjectTojson(messageObject);
             }
}
