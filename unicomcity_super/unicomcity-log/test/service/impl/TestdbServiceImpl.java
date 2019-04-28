package test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unicomcity.common.controller.MessageObject;
import com.unicomcity.common.controller.MessageUtils;
import com.unicomcity.test.entity.Testdb;
import com.unicomcity.test.mapper.TestdbMapper;
import com.unicomcity.test.service.ITestdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试数据库 服务实现类
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-18
 */
@Service
public class TestdbServiceImpl extends ServiceImpl<TestdbMapper, Testdb> implements ITestdbService {
            @Autowired
            private TestdbMapper testdbMapper;
             public String queryListTestdb(String json){
                    Testdb _testdb_querylist = new  Testdb();
                    MessageObject messageObject =  MessageUtils.ObectToClass("queryListTestdb", json, _testdb_querylist, null);
                    QueryWrapper<Testdb> _testdb_querylist_wrapper = new QueryWrapper<>();
                    _testdb_querylist_wrapper.eq("username",_testdb_querylist.getUsername());
                    Page<Testdb> _testdb_querylist_page = new Page<>(messageObject.getPagesize(),messageObject.getCurrent());
                    IPage<Testdb> _testdb_query_ipage = this.page(_testdb_querylist_page,_testdb_querylist_wrapper);
                    messageObject.setCode("1001");
                    messageObject.setPages(_testdb_query_ipage.getTotal());
                    messageObject.setContent(_testdb_querylist_page.getRecords());
                    messageObject.setOriginal(null);
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String insertTestdb(String json){
                    Testdb _testdb_insert = new  Testdb();
                    MessageObject messageObject =  MessageUtils.ObectToClass("insertTestdb", json,  _testdb_insert,null);
                    _testdb_insert = ( Testdb) messageObject.getContent();
                    int _testdb_insert_rep =  testdbMapper.insert(_testdb_insert);
                    if(_testdb_insert_rep>0){
                        messageObject.setCode("1001");
                        messageObject.setContent("您新增成功");
                    }
                    messageObject.setOriginal(null);
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String updateTestdb(String json){
                    Testdb _testdb_update = new   Testdb();
                    MessageObject messageObject =  MessageUtils.ObectToClass("updateTestdb", json,  _testdb_update,null);
                    _testdb_update = (  Testdb) messageObject.getContent();
                    UpdateWrapper _testdb_update_wrapper = new UpdateWrapper();
                    _testdb_update_wrapper.eq("id",_testdb_update.getId());
                    boolean _testdb_update_rep =  this.update(_testdb_update_wrapper);
                    if(_testdb_update_rep){
                        messageObject.setCode("1001");
                        messageObject.setContent("您新增成功");
                    }
                    messageObject.setOriginal(null);
                    return MessageUtils.ObjectTojson(messageObject);
             }
             public String deleteTestdb(String json){
                     Testdb _testdb_delete = new Testdb();
                     MessageObject messageObject =  MessageUtils.ObectToClass("deleteTestdb", json,  _testdb_delete,null);
                     _testdb_delete = (Testdb) messageObject.getContent();
                     QueryWrapper _testdb_delete_wrapper = new QueryWrapper();
                     _testdb_delete_wrapper.eq("id",_testdb_delete.getId());
                     boolean _testdb_delete_rep =  this.remove(_testdb_delete_wrapper);
                     if(_testdb_delete_rep){
                         messageObject.setCode("1001");
                         messageObject.setContent("您新增成功");
                     }
                     messageObject.setOriginal(null);
                     return MessageUtils.ObjectTojson(messageObject);
             }
}
