package com.unicomcity.demo.mapper;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.unicomcity.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unicomcity.demo.entity.UserAndUserinfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-23
 */
public interface UserMapper extends BaseMapper<User> {
    String JOIN_SQL = "SELECT * FROM user as user LEFT JOIN user_info as user_info ON user.userid = user_info.userid";
    @Select({JOIN_SQL})
    List<UserAndUserinfo> queryUserAndUserinfoList(Page<UserAndUserinfo> pagination);
    @Select({JOIN_SQL, "WHERE user.userid = #{userid}"})
    List<UserAndUserinfo> queryUserAndUserinfoListCuton(Page<UserAndUserinfo> pagination,Long userid);
}