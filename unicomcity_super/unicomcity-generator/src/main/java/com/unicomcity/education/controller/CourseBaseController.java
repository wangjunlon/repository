package com.unicomcity.education.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.unicomcity.education.service.ICourseBaseService;
import com.unicomcity.education.entity.CourseBase;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王军龙
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/courseBase")
public class CourseBaseController {
        @Autowired
        private ICourseBaseService course_baseService;
        @RequestMapping("/queryListCourseBase")
        public String queryListCourseBase(@RequestBody String json){
                return course_baseService.queryListCourseBase(json);
        }
        @RequestMapping("/insertCourseBase")
        public String insertCourseBase(@RequestBody String json){
               return  course_baseService.insertCourseBase(json);
        }
        @RequestMapping("/updateCourseBase")
        public String updateCourseBase(@RequestBody String json){
               return  course_baseService.updateCourseBase(json);
        }
         @RequestMapping("/deleteCourseBase")
         public String deleteCourseBase(@RequestBody String json){
              return  course_baseService.deleteCourseBase(json);
         }
}
