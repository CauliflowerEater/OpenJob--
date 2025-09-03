package io.openjob.server.log.client;

import java.util.Objects;

import io.openjob.server.log.autoconfigure.LogProperties;
import io.openjob.server.log.constant.LogJdbcDriverConstant;


public class MysqlClient extends AbstractJdbcHikariClient {
    private final LogProperties.MysqlProperties mysqlProperties;

    /**
     * New mysql client.
     *
     * @param mysqlProperties mysql properties
     */
    public MysqlClient(LogProperties.MysqlProperties mysqlProperties) {
        this.mysqlProperties = mysqlProperties;
    }

    @Override
    public void afterPropertiesSet() {
        // Driver
        LogProperties.JdbcProperties properties = mysqlProperties.getProperties();
        if (Objects.isNull(properties.getDriver())) {
            properties.setDriver(LogJdbcDriverConstant.MYSQL);
        }

        this.init(properties);
    }
}
