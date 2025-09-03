package io.openjob.server.repository.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.openjob.server.repository.entity.Job;


public interface JobRepository extends JpaRepository<Job, Long> {

    /**
     * Find by ids
     *
     * @param ids ids
     * @return List
     */
    List<Job> findByIdIn(List<Long> ids);

    /**
     * Find jobs by condition.
     *
     * @param slotIds slotIds
     * @param status  status
     * @param types   types
     * @param time    time
     * @param deleted deleted
     * @return jobs
     */
    List<Job> findBySlotsIdInAndStatusAndTimeExpressionTypeNotInAndNextExecuteTimeLessThanEqualAndDeleted(List<Long> slotIds, Integer status, List<String> types, Long time, Integer deleted);

    /**
     * Find first by namespace id and app id
     *
     * @param namespaceId namespaceId
     * @param appId       appId
     * @param deleted     deleted
     * @return Job
     */
    Job findFirstByNamespaceIdAndAppIdAndDeleted(Long namespaceId, Long appId, Integer deleted);

    /**
     * Count by namespace
     *
     * @param namespaceId namespaceId
     * @param deleted     deleted
     * @return Long
     */
    Long countByNamespaceIdAndDeleted(Long namespaceId, Integer deleted);

    /**
     * Count by namespace and create time
     *
     * @param namespaceId namespaceId
     * @param startTime   startTime
     * @param endTime     endTime
     * @param deleted     deleted
     * @return Long
     */
    Long countByNamespaceIdAndCreateTimeGreaterThanEqualAndCreateTimeLessThanEqualAndDeleted(Long namespaceId, Long startTime, Long endTime, Integer deleted);

}
