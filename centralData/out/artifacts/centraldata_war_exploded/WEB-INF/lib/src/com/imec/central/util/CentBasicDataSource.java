package com.imec.central.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

/**
 * Created by shinny on 2017-07-06.
 */
public class CentBasicDataSource extends BasicDataSource{
    @Override
    public synchronized void close() throws SQLException{
        System.out.println("......输出数据源Driver的url："+DriverManager.getDriver(url));
        DriverManager.deregisterDriver(DriverManager.getDriver(url));
        super.close();
    }
}
