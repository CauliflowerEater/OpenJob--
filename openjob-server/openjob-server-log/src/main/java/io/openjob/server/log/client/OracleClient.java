package io.openjob.server.log.client;

import java.sql.SQLException;
import java.util.Objects;

import io.openjob.server.log.autoconfigure.LogProperties;
import io.openjob.server.log.constant.LogJdbcDriverConstant;


public class OracleClient extends AbstractJdbcHikariClient {
    private final LogProperties.OracleProperties oracleProperties;

    public OracleClient(LogProperties.OracleProperties oracleProperties) {
        this.oracleProperties = oracleProperties;
    }

    //todo
    //Oracle的日志表初始化语句未实现
    @Override
    public void initTable() throws SQLException {
    }

    @Override
    public void afterPropertiesSet() {
        // Driver
        LogProperties.JdbcProperties properties = oracleProperties.getProperties();
        if (Objects.isNull(properties.getDriver())) {
            properties.setDriver(LogJdbcDriverConstant.ORACLE);
        }

        this.init(properties);
    }
}
