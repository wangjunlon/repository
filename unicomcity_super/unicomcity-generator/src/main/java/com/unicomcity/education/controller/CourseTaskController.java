package com.unicomcity.education.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.unicomcity.education.service.ICourseTaskService;
import com.unicomcity.education.entity.CourseTask;
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
@RequestMapping("/courseTask")
public class CourseTaskController {
        @Autowired
        private ICourseTaskService course_taskService;
        @RequestMapping("/queryListCourseTask")
        public String queryListCourseTask(@RequestBody String json){
                return course_taskService.queryListCourseTask(json);
        }
        @RequestMapping("/insertCourseTask")
        public String insertCourseTask(@RequestBody String json){
               return  course_taskService.insertCourseTask(json);
        }
        @RequestMapping("/updateCourseTask")
        public String updateCourseTask(@RequestBody String json){
               return  course_taskService.updateCourseTask(json);
        }
         @RequestMapping("/deleteCourseTask")
         public String deleteCourseTask(@RequestBody String json){
              return  course_taskService.deleteCourseTask(json);
         }
}
