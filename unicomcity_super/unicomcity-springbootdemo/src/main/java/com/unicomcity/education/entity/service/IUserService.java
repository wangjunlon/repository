package com.unicomcity.education.entity.service;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-23
 */
public interface IUserService {
    public String queryListUser(String json);
    public String insertUser(String json);
    public String updateUser(String json);
    public String deleteUser(String json);
    public String queryListUserAndUserinfo(String json);
}
