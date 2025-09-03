package io.openjob.server.log.client;

import java.util.Objects;

import io.openjob.server.log.autoconfigure.LogProperties;
import io.openjob.server.log.constant.LogJdbcDriverConstant;


public class PostgresqlClient extends AbstractJdbcHikariClient {
    private final LogProperties.PostgresqlProperties postgresqlProperties;

    public PostgresqlClient(LogProperties.PostgresqlProperties postgresqlProperties) {
        this.postgresqlProperties = postgresqlProperties;
    }

    //todo
    //psgsql的log表初始化语句也没有实现
    @Override
    public void initTable() {

    }

    @Override
    public void afterPropertiesSet() {
        // Driver
        LogProperties.JdbcProperties properties = postgresqlProperties.getProperties();
        if (Objects.isNull(properties.getDriver())) {
            properties.setDriver(LogJdbcDriverConstant.POSTGRESQL);
        }

        this.init(properties);
    }
}
