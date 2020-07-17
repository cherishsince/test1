package cn.coget.test.bean.classLoader;

import com.mysql.cj.jdbc.Driver;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Mysql 的 Driver classLoader 加载机制
 *
 * author: Sin
 * time: 2020/7/17 16:59
 */
public class ClassLoaderTests {

    @Before
    public void setup() {

    }

    @Test
    public void loaderTest() throws SQLException {
        Driver driver = new Driver();
        System.err.println(driver.hashCode());
    }
}
