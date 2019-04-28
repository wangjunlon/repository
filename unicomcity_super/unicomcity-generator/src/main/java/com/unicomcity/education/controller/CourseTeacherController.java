package com.unicomcity.education.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.unicomcity.education.service.ICourseTeacherService;
import com.unicomcity.education.entity.CourseTeacher;
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
@RequestMapping("/courseTeacher")
public class CourseTeacherController {
        @Autowired
        private ICourseTeacherService course_teacherService;
        @RequestMapping("/queryListCourseTeacher")
        public String queryListCourseTeacher(@RequestBody String json){
                return course_teacherService.queryListCourseTeacher(json);
        }
        @RequestMapping("/insertCourseTeacher")
        public String insertCourseTeacher(@RequestBody String json){
               return  course_teacherService.insertCourseTeacher(json);
        }
        @RequestMapping("/updateCourseTeacher")
        public String updateCourseTeacher(@RequestBody String json){
               return  course_teacherService.updateCourseTeacher(json);
        }
         @RequestMapping("/deleteCourseTeacher")
         public String deleteCourseTeacher(@RequestBody String json){
              return  course_teacherService.deleteCourseTeacher(json);
         }
}
