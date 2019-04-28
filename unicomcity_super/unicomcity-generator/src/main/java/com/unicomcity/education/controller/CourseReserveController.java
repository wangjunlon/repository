package com.unicomcity.education.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.unicomcity.education.service.ICourseReserveService;
import com.unicomcity.education.entity.CourseReserve;
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
@RequestMapping("/courseReserve")
public class CourseReserveController {
        @Autowired
        private ICourseReserveService course_reserveService;
        @RequestMapping("/queryListCourseReserve")
        public String queryListCourseReserve(@RequestBody String json){
                return course_reserveService.queryListCourseReserve(json);
        }
        @RequestMapping("/insertCourseReserve")
        public String insertCourseReserve(@RequestBody String json){
               return  course_reserveService.insertCourseReserve(json);
        }
        @RequestMapping("/updateCourseReserve")
        public String updateCourseReserve(@RequestBody String json){
               return  course_reserveService.updateCourseReserve(json);
        }
         @RequestMapping("/deleteCourseReserve")
         public String deleteCourseReserve(@RequestBody String json){
              return  course_reserveService.deleteCourseReserve(json);
         }
}
