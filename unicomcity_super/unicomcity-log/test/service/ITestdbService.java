package test.service;

/**
 * <p>
 * 测试数据库 服务类
 * </p>
 *
 * @author 刘冰
 * @since 2019-04-18
 */
public interface ITestdbService {
    public String queryListTestdb(String json);
    public String insertTestdb(String json);
    public String updateTestdb(String json);
    public String deleteTestdb(String json);
}
