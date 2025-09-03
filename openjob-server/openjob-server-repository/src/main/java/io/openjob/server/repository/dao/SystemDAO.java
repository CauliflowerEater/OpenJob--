package io.openjob.server.repository.dao;

import io.openjob.server.repository.entity.System;


public interface SystemDAO {

    /**
     * Get one.
     *
     * @return system
     */
    System getOne();

    /**
     * Update by id
     *
     * @param clusterVersion cluster version.
     * @return effect rows.
     */
    Integer updateClusterVersion(Long clusterVersion);

    /**
     * Update cluster delay version
     *
     * @param clusterDelayVersion clusterDelayVersion
     * @return Integer
     */
    Integer updateClusterDelayVersion(Long clusterDelayVersion);

    //这段的描述明显有问题
    //todo

    /**
     * update by id
     *
     * @param system update Params
     */
    void updateById(System system);
}
