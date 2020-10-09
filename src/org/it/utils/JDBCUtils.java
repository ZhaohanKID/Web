package org.it.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/6 17:35
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            Properties prop = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            prop.load(is);
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接池对象
    public static DataSource getDs() {
        return ds;
    }

    // 获取Connection
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
