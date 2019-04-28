package com.unicomcity.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.unicomcity.education.entity.service.IUserInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户基础信息 前端控制器
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
        @Autowired
        private IUserInfoService user_infoService;
        @RequestMapping("/queryListUserInfo")
        public String queryListUserInfo(@RequestBody String json){
                return user_infoService.queryListUserInfo(json);
        }
        @RequestMapping("/insertUserInfo")
        public String insertUserInfo(@RequestBody String json){
               return  user_infoService.insertUserInfo(json);
        }
        @RequestMapping("/updateUserInfo")
        public String updateUserInfo(@RequestBody String json){
               return  user_infoService.updateUserInfo(json);
        }
         @RequestMapping("/deleteUserInfo")
         public String deleteUserInfo(@RequestBody String json){
              return  user_infoService.deleteUserInfo(json);
         }
}
