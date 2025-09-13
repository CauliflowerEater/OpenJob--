package io.openjob.server.scheduler.contract;


public interface DelayScheduler {

    /**
     * Delay scheduler start.
     */
    void start();

    /**
     * Delay scheduler stop.
     */
    void stop();

    /**
     * Refresh
     */
    void refresh();
}
