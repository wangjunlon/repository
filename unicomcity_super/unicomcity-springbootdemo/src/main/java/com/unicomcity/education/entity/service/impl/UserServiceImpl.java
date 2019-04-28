package com.unicomcity.education.entity.service.impl;

import com.unicomcity.demo.entity.User;
import com.unicomcity.demo.entity.UserAndUserinfo;
import com.unicomcity.demo.mapper.UserMapper;
import com.unicomcity.education.entity.service.IUserService;
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
 * 用户信息 服务实现类
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
            @Autowired
            private UserMapper userMapper;
             public String queryListUser(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, User.class);
                    User  _user_querylist = (User) messageObject.getContent();
                    QueryWrapper<User> _user_querylist_wrapper = new QueryWrapper<>();
                    Page<User> _user_querylist_page = new Page<>(messageObject.getPagesize(),messageObject.getCurrent());
                    IPage<User> _user_query_ipage = this.page(_user_querylist_page,_user_querylist_wrapper);
                    messageObject.setCode("1000");
                    messageObject.setPages(_user_query_ipage.getTotal());
                    messageObject.setContent(_user_querylist_page.getRecords());
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String insertUser(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, User.class);
                     User _user_insert = ( User) messageObject.getContent();
                    int _user_insert_rep =  userMapper.insert(_user_insert);
                    if(_user_insert_rep>0){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String updateUser(String json){
                    MessageObject messageObject =  MessageUtils.ObectToClass(json,User.class);
                    User _user_update = (  User) messageObject.getContent();
                    UpdateWrapper _user_update_wrapper = new UpdateWrapper();
                     _user_update_wrapper.eq("id",_user_update.getId());
                    boolean _user_update_rep =  this.update(_user_update_wrapper);
                    if(_user_update_rep){
                        messageObject.setCode("1000");
                        messageObject.setContent("您新增成功");
                    }
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String deleteUser(String json){
                     MessageObject messageObject =  MessageUtils.ObectToClass(json,User.class);
                     User _user_delete = (User) messageObject.getContent();
                     QueryWrapper _user_delete_wrapper = new QueryWrapper();
                     _user_delete_wrapper.eq("id",_user_delete.getId());
                     boolean _user_delete_rep =  this.remove(_user_delete_wrapper);
                     if(_user_delete_rep){
                         messageObject.setCode("1000");
                         messageObject.setContent("您新增成功");
                     }
                     return MessageUtils.ObjectTojson(messageObject);
             }

            public String queryListUserAndUserinfo(String json) {
                    MessageObject messageObject =  MessageUtils.ObectToClass(json, UserAndUserinfo.class);
                    UserAndUserinfo _user_querylist = (UserAndUserinfo) messageObject.getContent();
                    Page<UserAndUserinfo> _user_querylist_page = new Page<>(messageObject.getPagesize(),messageObject.getCurrent());
                    if(_user_querylist.getUserid()>0) {
                        _user_querylist_page.setRecords(userMapper.queryUserAndUserinfoListCuton(_user_querylist_page,_user_querylist.getUserid()));
                    }else {
                        _user_querylist_page.setRecords(userMapper.queryUserAndUserinfoList(_user_querylist_page));
                    }
                    messageObject.setCode("1000");
                    messageObject.setPages(_user_querylist_page.getTotal());
                    messageObject.setContent(_user_querylist_page.getRecords());
                    return MessageUtils.ObjectTojson(messageObject);
    }
}
