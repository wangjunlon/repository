package com.unicomcity.demo.controller;
import com.unicomcity.common.validator.Query;
import com.unicomcity.common.validator.Validate;
import com.unicomcity.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.unicomcity.education.entity.service.IUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/user")
public class UserController {
        @Autowired
        private IUserService userService;
        /**
         * 测试查询数据用户名必须为空
         * **/
        @RequestMapping("/queryListUser")
        public String queryListUser(@Validate(valiclass= User.class,groups = {Query.class})@RequestBody String json){
                return userService.queryListUser(json);
        }
        @RequestMapping("/queryListUserAndUserinfo")
        public String queryListUserAndUserinfo(@RequestBody String json){
            return userService.queryListUserAndUserinfo(json);
        }
        @RequestMapping("/insertUser")
        public String insertUser(@RequestBody String json){
               return  userService.insertUser(json);
        }
        @RequestMapping("/updateUser")
        public String updateUser(@RequestBody String json){
               return  userService.updateUser(json);
        }
         @RequestMapping("/deleteUser")
         public String deleteUser(@RequestBody String json){
              return  userService.deleteUser(json);
         }
}
