package com.unicomcity.education.service.impl;

import com.unicomcity.education.entity.CourseBase;
import com.unicomcity.education.mapper.CourseBaseMapper;
import com.unicomcity.education.service.ICourseBaseService;
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
public class CourseBaseServiceImpl extends ServiceImpl<CourseBaseMapper, CourseBase> implements ICourseBaseService {
            @Autowired
            private CourseBaseMapper course_baseMapper;
             public String queryListCourseBase(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, CourseBase.class);
                    CourseBase  _course_base_querylist = (CourseBase) messageObject.getContent();
                    QueryWrapper<CourseBase> _course_base_querylist_wrapper = new QueryWrapper<>();
                    _course_base_querylist_wrapper.eq("id",_course_base_querylist.getId());
                    _course_base_querylist_wrapper.eq("cur_id",_course_base_querylist.getCurId());
                    _course_base_querylist_wrapper.eq("week_count",_course_base_querylist.getWeekCount());
                    _course_base_querylist_wrapper.eq("am_count",_course_base_querylist.getAmCount());
                    _course_base_querylist_wrapper.eq("pm_count",_course_base_querylist.getPmCount());
                    _course_base_querylist_wrapper.eq("nt_count",_course_base_querylist.getNtCount());
                    _course_base_querylist_wrapper.eq("gmt_create",_course_base_querylist.getGmtCreate());
                    _course_base_querylist_wrapper.eq("create_by",_course_base_querylist.getCreateBy());
                    _course_base_querylist_wrapper.eq("is_deleted",_course_base_querylist.getIsDeleted());
                    _course_base_querylist_wrapper.eq("backup_a",_course_base_querylist.getBackupA());
                    _course_base_querylist_wrapper.eq("backup_b",_course_base_querylist.getBackupB());
                    Page<CourseBase> _course_base_querylist_page = new Page<>(messageObject.getPagesize(),messageObject.getCurrent());
                    IPage<CourseBase> _course_base_query_ipage = this.page(_course_base_querylist_page,_course_base_querylist_wrapper);
                    messageObject.setCode("1000");
                    messageObject.setPages(_course_base_query_ipage.getTotal());
                    messageObject.setContent(_course_base_querylist_page.getRecords());
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String insertCourseBase(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, CourseBase.class);
                     CourseBase _course_base_insert = ( CourseBase) messageObject.getContent();
                    int _course_base_insert_rep =  course_baseMapper.insert(_course_base_insert);
                    if(_course_base_insert_rep>0){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String updateCourseBase(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json,CourseBase.class);
                    CourseBase _course_base_update = (  CourseBase) messageObject.getContent();
                    UpdateWrapper _course_base_update_wrapper = new UpdateWrapper();
                     _course_base_update_wrapper.eq("id",_course_base_update.getId());
                    boolean _course_base_update_rep =  this.update(_course_base_update_wrapper);
                    if(_course_base_update_rep){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String deleteCourseBase(String json){
                     MessageObject messageObject =  MessageUtils.ObectToClass(json,CourseBase.class);
                     CourseBase _course_base_delete = (CourseBase) messageObject.getContent();
                     QueryWrapper _course_base_delete_wrapper = new QueryWrapper();
                     _course_base_delete_wrapper.eq("id",_course_base_delete.getId());
                     boolean _course_base_delete_rep =  this.remove(_course_base_delete_wrapper);
                     if(_course_base_delete_rep){
                         messageObject.setCode("1000");
                         messageObject.setContent("您新增成功");
                     }
                     return MessageUtils.ObjectTojson(messageObject);
             }
}
