package com.unicomcity.education.service.impl;

import com.unicomcity.education.entity.CourseTask;
import com.unicomcity.education.mapper.CourseTaskMapper;
import com.unicomcity.education.service.ICourseTaskService;
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
public class CourseTaskServiceImpl extends ServiceImpl<CourseTaskMapper, CourseTask> implements ICourseTaskService {
            @Autowired
            private CourseTaskMapper course_taskMapper;
             public String queryListCourseTask(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, CourseTask.class);
                    CourseTask  _course_task_querylist = (CourseTask) messageObject.getContent();
                    QueryWrapper<CourseTask> _course_task_querylist_wrapper = new QueryWrapper<>();
                    _course_task_querylist_wrapper.eq("id",_course_task_querylist.getId());
                    _course_task_querylist_wrapper.eq("NAME",_course_task_querylist.getName());
                    _course_task_querylist_wrapper.eq("type_id",_course_task_querylist.getTypeId());
                    _course_task_querylist_wrapper.eq("state",_course_task_querylist.getState());
                    _course_task_querylist_wrapper.eq("schid",_course_task_querylist.getSchid());
                    _course_task_querylist_wrapper.eq("sch_sname",_course_task_querylist.getSchSname());
                    _course_task_querylist_wrapper.eq("gmt_create",_course_task_querylist.getGmtCreate());
                    _course_task_querylist_wrapper.eq("gmt_modified",_course_task_querylist.getGmtModified());
                    _course_task_querylist_wrapper.eq("create_by",_course_task_querylist.getCreateBy());
                    _course_task_querylist_wrapper.eq("update_by",_course_task_querylist.getUpdateBy());
                    _course_task_querylist_wrapper.eq("is_deleted",_course_task_querylist.getIsDeleted());
                    _course_task_querylist_wrapper.eq("backup_a",_course_task_querylist.getBackupA());
                    _course_task_querylist_wrapper.eq("backup_b",_course_task_querylist.getBackupB());
                    Page<CourseTask> _course_task_querylist_page = new Page<>(messageObject.getPagesize(),messageObject.getCurrent());
                    IPage<CourseTask> _course_task_query_ipage = this.page(_course_task_querylist_page,_course_task_querylist_wrapper);
                    messageObject.setCode("1000");
                    messageObject.setPages(_course_task_query_ipage.getTotal());
                    messageObject.setContent(_course_task_querylist_page.getRecords());
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String insertCourseTask(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, CourseTask.class);
                     CourseTask _course_task_insert = ( CourseTask) messageObject.getContent();
                    int _course_task_insert_rep =  course_taskMapper.insert(_course_task_insert);
                    if(_course_task_insert_rep>0){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String updateCourseTask(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json,CourseTask.class);
                    CourseTask _course_task_update = (  CourseTask) messageObject.getContent();
                    UpdateWrapper _course_task_update_wrapper = new UpdateWrapper();
                     _course_task_update_wrapper.eq("id",_course_task_update.getId());
                    boolean _course_task_update_rep =  this.update(_course_task_update_wrapper);
                    if(_course_task_update_rep){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String deleteCourseTask(String json){
                     MessageObject messageObject =  MessageUtils.ObectToClass(json,CourseTask.class);
                     CourseTask _course_task_delete = (CourseTask) messageObject.getContent();
                     QueryWrapper _course_task_delete_wrapper = new QueryWrapper();
                     _course_task_delete_wrapper.eq("id",_course_task_delete.getId());
                     boolean _course_task_delete_rep =  this.remove(_course_task_delete_wrapper);
                     if(_course_task_delete_rep){
                         messageObject.setCode("1000");
                         messageObject.setContent("您新增成功");
                     }
                     return MessageUtils.ObjectTojson(messageObject);
             }
}
