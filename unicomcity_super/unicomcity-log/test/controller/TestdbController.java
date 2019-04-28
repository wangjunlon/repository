package test.controller;


import com.unicomcity.test.service.ITestdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 测试数据库 前端控制器
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-18
 */
@Controller
@RequestMapping("/testdb")
public class TestdbController {
        @Autowired
        private ITestdbService testdbService;
        @PostMapping("/queryListTestdb")
        @ResponseBody
        public String queryListTestdb(String json){
                return testdbService.queryListTestdb(json);
        }
        @PostMapping("/insertTestdb")
        @ResponseBody
        public String insertTestdb(String json){
               return  testdbService.insertTestdb(json);
        }
        @PostMapping("/updateTestdb")
        @ResponseBody
        public String updateTestdb(String json){
               return  testdbService.updateTestdb(json);
        }
         @PostMapping("/deleteTestdb")
         @ResponseBody
         public String deleteTestdb(String json){
              return  testdbService.deleteTestdb(json);
         }
}
