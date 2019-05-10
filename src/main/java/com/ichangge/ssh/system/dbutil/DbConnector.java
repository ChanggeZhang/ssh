package com.ichangge.ssh.system.dbutil;

import org.springframework.jdbc.datasource.ConnectionProxy;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;

public class DbConnector{
    DataSource dataSource;

    public DbConnector(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DbConnector() {
    }

    public Connection getConnection() {
        Connection connection = DataSourceUtils.getConnection(dataSource);
        return connection;
    }
}
