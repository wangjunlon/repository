package com.unicomcity.education.entity.service.impl;

import com.unicomcity.demo.entity.UserInfo;
import com.unicomcity.demo.mapper.UserInfoMapper;
import com.unicomcity.education.entity.service.IUserInfoService;
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
 * 用户基础信息 服务实现类
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-23
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
            @Autowired
            private UserInfoMapper user_infoMapper;
             public String queryListUserInfo(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, UserInfo.class);
                    UserInfo  _user_info_querylist = (UserInfo) messageObject.getContent();//获取主体对象

                    QueryWrapper<UserInfo> _user_info_querylist_wrapper = new QueryWrapper<>();

                    _user_info_querylist_wrapper.eq("userid",_user_info_querylist.getUserid());
                    _user_info_querylist_wrapper.eq("host",_user_info_querylist.getHost());
                    _user_info_querylist_wrapper.eq("name",_user_info_querylist.getName());
                    _user_info_querylist_wrapper.eq("id_crad",_user_info_querylist.getIdCrad());
                    _user_info_querylist_wrapper.eq("createtime",_user_info_querylist.getCreatetime());
                    _user_info_querylist_wrapper.eq("createid",_user_info_querylist.getCreateid());

                    Page<UserInfo> _user_info_querylist_page = new Page<>(messageObject.getPagesize(),messageObject.getCurrent());

                    IPage<UserInfo> _user_info_query_ipage = this.page(_user_info_querylist_page,_user_info_querylist_wrapper);

                    messageObject.setCode("1000");
                    messageObject.setPages(_user_info_query_ipage.getTotal());
                    messageObject.setContent(_user_info_querylist_page.getRecords());
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String insertUserInfo(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, UserInfo.class);

                     UserInfo _user_info_insert = ( UserInfo) messageObject.getContent();

                    int _user_info_insert_rep =  user_infoMapper.insert(_user_info_insert);

                    if(_user_info_insert_rep>0){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String updateUserInfo(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json,UserInfo.class);
                    UserInfo _user_info_update = (  UserInfo) messageObject.getContent();
                    UpdateWrapper _user_info_update_wrapper = new UpdateWrapper();

                     _user_info_update_wrapper.eq("id",_user_info_update.getId());
                    boolean _user_info_update_rep =  this.update(_user_info_update_wrapper);
                    if(_user_info_update_rep){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String deleteUserInfo(String json){
                     MessageObject messageObject =  MessageUtils.ObectToClass(json,UserInfo.class);
                     UserInfo _user_info_delete = (UserInfo) messageObject.getContent();
                     QueryWrapper _user_info_delete_wrapper = new QueryWrapper();

                     _user_info_delete_wrapper.eq("id",_user_info_delete.getId());
                     boolean _user_info_delete_rep =  this.remove(_user_info_delete_wrapper);
                     if(_user_info_delete_rep){
                         messageObject.setCode("1000");
                         messageObject.setContent("您新增成功");
                     }
                     return MessageUtils.ObjectTojson(messageObject);
             }
}
