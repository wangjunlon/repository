package com.unicomcity.education.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.unicomcity.education.service.ICourseService;
import com.unicomcity.education.entity.Course;
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
@RequestMapping("/course")
public class CourseController {
        @Autowired
        private ICourseService courseService;
        @RequestMapping("/queryListCourse")
        public String queryListCourse(@RequestBody String json){
                return courseService.queryListCourse(json);
        }
        @RequestMapping("/insertCourse")
        public String insertCourse(@RequestBody String json){
               return  courseService.insertCourse(json);
        }
        @RequestMapping("/updateCourse")
        public String updateCourse(@RequestBody String json){
               return  courseService.updateCourse(json);
        }
         @RequestMapping("/deleteCourse")
         public String deleteCourse(@RequestBody String json){
              return  courseService.deleteCourse(json);
         }
}
