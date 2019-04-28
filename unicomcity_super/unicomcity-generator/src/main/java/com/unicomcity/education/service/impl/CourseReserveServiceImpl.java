package com.unicomcity.education.service.impl;

import com.unicomcity.education.entity.CourseReserve;
import com.unicomcity.education.mapper.CourseReserveMapper;
import com.unicomcity.education.service.ICourseReserveService;
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
public class CourseReserveServiceImpl extends ServiceImpl<CourseReserveMapper, CourseReserve> implements ICourseReserveService {
            @Autowired
            private CourseReserveMapper course_reserveMapper;
             public String queryListCourseReserve(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, CourseReserve.class);
                    CourseReserve  _course_reserve_querylist = (CourseReserve) messageObject.getContent();
                    QueryWrapper<CourseReserve> _course_reserve_querylist_wrapper = new QueryWrapper<>();
                    _course_reserve_querylist_wrapper.eq("id",_course_reserve_querylist.getId());
                    _course_reserve_querylist_wrapper.eq("cur_id",_course_reserve_querylist.getCurId());
                    _course_reserve_querylist_wrapper.eq("TYPE",_course_reserve_querylist.getType());
                    _course_reserve_querylist_wrapper.eq("grade_id",_course_reserve_querylist.getGradeId());
                    _course_reserve_querylist_wrapper.eq("grade_name",_course_reserve_querylist.getGradeName());
                    _course_reserve_querylist_wrapper.eq("clazz_id",_course_reserve_querylist.getClazzId());
                    _course_reserve_querylist_wrapper.eq("clazz_sname",_course_reserve_querylist.getClazzSname());
                    _course_reserve_querylist_wrapper.eq("WEEK",_course_reserve_querylist.getWeek());
                    _course_reserve_querylist_wrapper.eq("sequence",_course_reserve_querylist.getSequence());
                    _course_reserve_querylist_wrapper.eq("course_id",_course_reserve_querylist.getCourseId());
                    _course_reserve_querylist_wrapper.eq("course_name",_course_reserve_querylist.getCourseName());
                    _course_reserve_querylist_wrapper.eq("teacher_id",_course_reserve_querylist.getTeacherId());
                    _course_reserve_querylist_wrapper.eq("teacher_name",_course_reserve_querylist.getTeacherName());
                    _course_reserve_querylist_wrapper.eq("create_by",_course_reserve_querylist.getCreateBy());
                    _course_reserve_querylist_wrapper.eq("gmt_create",_course_reserve_querylist.getGmtCreate());
                    _course_reserve_querylist_wrapper.eq("gmt_update",_course_reserve_querylist.getGmtUpdate());
                    _course_reserve_querylist_wrapper.eq("update_by",_course_reserve_querylist.getUpdateBy());
                    _course_reserve_querylist_wrapper.eq("is_deleted",_course_reserve_querylist.getIsDeleted());
                    _course_reserve_querylist_wrapper.eq("backup_a",_course_reserve_querylist.getBackupA());
                    _course_reserve_querylist_wrapper.eq("backup_b",_course_reserve_querylist.getBackupB());
                    Page<CourseReserve> _course_reserve_querylist_page = new Page<>(messageObject.getPagesize(),messageObject.getCurrent());
                    IPage<CourseReserve> _course_reserve_query_ipage = this.page(_course_reserve_querylist_page,_course_reserve_querylist_wrapper);
                    messageObject.setCode("1000");
                    messageObject.setPages(_course_reserve_query_ipage.getTotal());
                    messageObject.setContent(_course_reserve_querylist_page.getRecords());
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String insertCourseReserve(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, CourseReserve.class);
                     CourseReserve _course_reserve_insert = ( CourseReserve) messageObject.getContent();
                    int _course_reserve_insert_rep =  course_reserveMapper.insert(_course_reserve_insert);
                    if(_course_reserve_insert_rep>0){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String updateCourseReserve(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json,CourseReserve.class);
                    CourseReserve _course_reserve_update = (  CourseReserve) messageObject.getContent();
                    UpdateWrapper _course_reserve_update_wrapper = new UpdateWrapper();
                     _course_reserve_update_wrapper.eq("id",_course_reserve_update.getId());
                    boolean _course_reserve_update_rep =  this.update(_course_reserve_update_wrapper);
                    if(_course_reserve_update_rep){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String deleteCourseReserve(String json){
                     MessageObject messageObject =  MessageUtils.ObectToClass(json,CourseReserve.class);
                     CourseReserve _course_reserve_delete = (CourseReserve) messageObject.getContent();
                     QueryWrapper _course_reserve_delete_wrapper = new QueryWrapper();
                     _course_reserve_delete_wrapper.eq("id",_course_reserve_delete.getId());
                     boolean _course_reserve_delete_rep =  this.remove(_course_reserve_delete_wrapper);
                     if(_course_reserve_delete_rep){
                         messageObject.setCode("1000");
                         messageObject.setContent("您新增成功");
                     }
                     return MessageUtils.ObjectTojson(messageObject);
             }
}
