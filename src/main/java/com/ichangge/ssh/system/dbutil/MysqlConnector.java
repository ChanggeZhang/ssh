package com.ichangge.ssh.system.dbutil;

import javax.sql.DataSource;

public class MysqlConnector extends DbConnector {
    public MysqlConnector(DataSource dataSource) {
        super(dataSource);
    }

    public MysqlConnector() {
    }

}
