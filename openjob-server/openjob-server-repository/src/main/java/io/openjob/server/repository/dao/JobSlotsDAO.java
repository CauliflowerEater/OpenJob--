package io.openjob.server.repository.dao;

import java.util.List;

import io.openjob.server.common.dto.PageDTO;
import io.openjob.server.repository.entity.JobSlots;


public interface JobSlotsDAO {
    /**
     * Save job slots.
     *
     * @param taskSlots taskSlots
     * @return Save id
     */
    Long save(JobSlots taskSlots);

    /**
     * List job slots by server id.
     *
     * @param serverId serverId
     * @return List
     */
    List<JobSlots> listJobSlotsByServerId(Long serverId);

    /**
     * List all job slots.
     *
     * @return List
     */
    List<JobSlots> listJobSlots();

    /**
     * Update slots by serverId and slots.
     *
     * @param serverId serverId
     * @param slots    slots
     * @return Effected rows.
     */
    Integer updateByServerId(Long serverId, List<Long> slots);

    /**
     * Update slots by server Id.
     *
     * @param serverId serverId
     * @return Effected rows.
     */
    Integer updateByServerId(Long serverId);

    /**
     * Count by all
     *
     * @return Long
     */
    Long countByAll();

    /**
     * Job slot
     *
     * @param page page
     * @param size size
     * @return PageDTO
     */
    PageDTO<JobSlots> pageList(Integer page, Integer size);
}
