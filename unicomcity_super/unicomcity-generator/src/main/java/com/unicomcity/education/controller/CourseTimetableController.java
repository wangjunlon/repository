package com.unicomcity.education.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.unicomcity.education.service.ICourseTimetableService;
import com.unicomcity.education.entity.CourseTimetable;
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
@RequestMapping("/courseTimetable")
public class CourseTimetableController {
        @Autowired
        private ICourseTimetableService course_timetableService;
        @RequestMapping("/queryListCourseTimetable")
        public String queryListCourseTimetable(@RequestBody String json){
                return course_timetableService.queryListCourseTimetable(json);
        }
        @RequestMapping("/insertCourseTimetable")
        public String insertCourseTimetable(@RequestBody String json){
               return  course_timetableService.insertCourseTimetable(json);
        }
        @RequestMapping("/updateCourseTimetable")
        public String updateCourseTimetable(@RequestBody String json){
               return  course_timetableService.updateCourseTimetable(json);
        }
         @RequestMapping("/deleteCourseTimetable")
         public String deleteCourseTimetable(@RequestBody String json){
              return  course_timetableService.deleteCourseTimetable(json);
         }
}
