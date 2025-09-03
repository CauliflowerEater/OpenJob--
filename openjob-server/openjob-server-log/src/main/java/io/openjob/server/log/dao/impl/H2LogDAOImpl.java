package io.openjob.server.log.dao.impl;

import io.openjob.server.log.client.H2Client;


public class H2LogDAOImpl extends JdbcDAOImpl {

    public H2LogDAOImpl(H2Client h2Client) {
        super(h2Client);
    }
}
