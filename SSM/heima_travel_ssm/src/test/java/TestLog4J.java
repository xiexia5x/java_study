import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author laofang
 * @description
 * @date 2021-06-20
 */
public class TestLog4J {

    //1.获取日志对象 绑定当前的类
    private static final Logger LOGGER= LoggerFactory.getLogger(TestLog4J.class);

    @Test
    public void test1()  {
        //DEBUG、INFO、WARN、ERROR
       LOGGER.debug("{}模式运行：{}","debug",666);
       LOGGER.info("{}模式运行：{}","info",777);
       LOGGER.warn("{}模式运行：{}","warning",888);
       LOGGER.error("{}模式运行：{}","error",666);
    }
}
