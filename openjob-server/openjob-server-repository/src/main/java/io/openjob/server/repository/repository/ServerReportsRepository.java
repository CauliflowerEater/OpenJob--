package io.openjob.server.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.openjob.server.repository.entity.ServerReports;

public interface ServerReportsRepository extends JpaRepository<ServerReports, Long> {

    /**
     * Count by condition.
     *
     * @param createTime create time.
     * @param serverId   server id.
     * @param status     status
     * @return Long
     */
    Long countByCreateTimeGreaterThanEqualAndServerIdAndStatus(Long createTime, Long serverId, Integer status);
}
