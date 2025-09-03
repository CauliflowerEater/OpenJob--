package io.openjob.server.repository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.openjob.server.repository.entity.JobInstanceLog;


public interface JobInstanceLogRepository extends JpaRepository<JobInstanceLog, Long> {

    /**
     * Find by job instance id.
     *
     * @param jobInstanceId jobInstanceId
     * @return List
     */
    List<JobInstanceLog> findByJobInstanceIdOrderByCreateTimeAsc(Long jobInstanceId);
}
