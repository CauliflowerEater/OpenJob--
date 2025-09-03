package io.openjob.server.log.client;

import java.io.IOException;

import org.springframework.beans.factory.InitializingBean;


public interface Client extends InitializingBean {
    /**
     * Connect
     *
     * @throws Exception Exception
     */
    void connect() throws Exception;

    /**
     * Shutdown
     *
     * @throws IOException IOException
     */
    void shutdown() throws IOException;
}
