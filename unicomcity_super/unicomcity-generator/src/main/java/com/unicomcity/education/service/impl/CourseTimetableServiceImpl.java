package com.unicomcity.education.service.impl;

import com.unicomcity.education.entity.CourseTimetable;
import com.unicomcity.education.mapper.CourseTimetableMapper;
import com.unicomcity.education.service.ICourseTimetableService;
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
public class CourseTimetableServiceImpl extends ServiceImpl<CourseTimetableMapper, CourseTimetable> implements ICourseTimetableService {
            @Autowired
            private CourseTimetableMapper course_timetableMapper;
             public String queryListCourseTimetable(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, CourseTimetable.class);
                    CourseTimetable  _course_timetable_querylist = (CourseTimetable) messageObject.getContent();
                    QueryWrapper<CourseTimetable> _course_timetable_querylist_wrapper = new QueryWrapper<>();
                    _course_timetable_querylist_wrapper.eq("id",_course_timetable_querylist.getId());
                    _course_timetable_querylist_wrapper.eq("cur_id",_course_timetable_querylist.getCurId());
                    _course_timetable_querylist_wrapper.eq("grade_id",_course_timetable_querylist.getGradeId());
                    _course_timetable_querylist_wrapper.eq("grade_name",_course_timetable_querylist.getGradeName());
                    _course_timetable_querylist_wrapper.eq("clazz_id",_course_timetable_querylist.getClazzId());
                    _course_timetable_querylist_wrapper.eq("clazz_sname",_course_timetable_querylist.getClazzSname());
                    _course_timetable_querylist_wrapper.eq("WEEK",_course_timetable_querylist.getWeek());
                    _course_timetable_querylist_wrapper.eq("sequence",_course_timetable_querylist.getSequence());
                    _course_timetable_querylist_wrapper.eq("course_id",_course_timetable_querylist.getCourseId());
                    _course_timetable_querylist_wrapper.eq("course_name",_course_timetable_querylist.getCourseName());
                    _course_timetable_querylist_wrapper.eq("teacher_id",_course_timetable_querylist.getTeacherId());
                    _course_timetable_querylist_wrapper.eq("teacher_name",_course_timetable_querylist.getTeacherName());
                    _course_timetable_querylist_wrapper.eq("create_by",_course_timetable_querylist.getCreateBy());
                    _course_timetable_querylist_wrapper.eq("gmt_create",_course_timetable_querylist.getGmtCreate());
                    _course_timetable_querylist_wrapper.eq("gmt_modified",_course_timetable_querylist.getGmtModified());
                    _course_timetable_querylist_wrapper.eq("update_by",_course_timetable_querylist.getUpdateBy());
                    _course_timetable_querylist_wrapper.eq("is_deleted",_course_timetable_querylist.getIsDeleted());
                    _course_timetable_querylist_wrapper.eq("backup_a",_course_timetable_querylist.getBackupA());
                    _course_timetable_querylist_wrapper.eq("backup_b",_course_timetable_querylist.getBackupB());
                    Page<CourseTimetable> _course_timetable_querylist_page = new Page<>(messageObject.getPagesize(),messageObject.getCurrent());
                    IPage<CourseTimetable> _course_timetable_query_ipage = this.page(_course_timetable_querylist_page,_course_timetable_querylist_wrapper);
                    messageObject.setCode("1000");
                    messageObject.setPages(_course_timetable_query_ipage.getTotal());
                    messageObject.setContent(_course_timetable_querylist_page.getRecords());
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String insertCourseTimetable(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, CourseTimetable.class);
                     CourseTimetable _course_timetable_insert = ( CourseTimetable) messageObject.getContent();
                    int _course_timetable_insert_rep =  course_timetableMapper.insert(_course_timetable_insert);
                    if(_course_timetable_insert_rep>0){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String updateCourseTimetable(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json,CourseTimetable.class);
                    CourseTimetable _course_timetable_update = (  CourseTimetable) messageObject.getContent();
                    UpdateWrapper _course_timetable_update_wrapper = new UpdateWrapper();
                     _course_timetable_update_wrapper.eq("id",_course_timetable_update.getId());
                    boolean _course_timetable_update_rep =  this.update(_course_timetable_update_wrapper);
                    if(_course_timetable_update_rep){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String deleteCourseTimetable(String json){
                     MessageObject messageObject =  MessageUtils.ObectToClass(json,CourseTimetable.class);
                     CourseTimetable _course_timetable_delete = (CourseTimetable) messageObject.getContent();
                     QueryWrapper _course_timetable_delete_wrapper = new QueryWrapper();
                     _course_timetable_delete_wrapper.eq("id",_course_timetable_delete.getId());
                     boolean _course_timetable_delete_rep =  this.remove(_course_timetable_delete_wrapper);
                     if(_course_timetable_delete_rep){
                         messageObject.setCode("1000");
                         messageObject.setContent("您新增成功");
                     }
                     return MessageUtils.ObjectTojson(messageObject);
             }
}
