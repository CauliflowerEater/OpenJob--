package io.openjob.server.log.dao.impl;

import io.openjob.server.log.client.MysqlClient;


public class MysqlLogDAOImpl extends JdbcDAOImpl {
    public MysqlLogDAOImpl(MysqlClient mysqlClient) {
        super(mysqlClient);
    }
}
