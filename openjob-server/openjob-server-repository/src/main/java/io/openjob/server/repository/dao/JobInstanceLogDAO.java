package io.openjob.server.repository.dao;

import java.util.List;

import io.openjob.server.repository.entity.JobInstanceLog;


public interface JobInstanceLogDAO {

    /**
     * Save
     *
     * @param jobInstanceLog jobInstanceLog
     * @return Long
     */
    Long save(JobInstanceLog jobInstanceLog);

    /**
     * Get by job instance id.
     *
     * @param jobInstanceId jobInstanceId
     * @return JobInstanceLog
     */
    List<JobInstanceLog> getByJobInstanceId(Long jobInstanceId);
}
