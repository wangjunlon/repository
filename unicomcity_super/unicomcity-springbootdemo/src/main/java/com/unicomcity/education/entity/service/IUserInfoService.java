package com.unicomcity.education.entity.service;

/**
 * <p>
 * 用户基础信息 服务类
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-23
 */
public interface IUserInfoService {
    public String queryListUserInfo(String json);
    public String insertUserInfo(String json);
    public String updateUserInfo(String json);
    public String deleteUserInfo(String json);
}
