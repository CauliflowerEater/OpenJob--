package io.openjob.server.repository.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.openjob.server.repository.entity.AdminPermission;


public interface AdminPermissionRepository extends JpaRepository<AdminPermission, Long> {
    /**
     * Find by ID In given list
     *
     * @param ids ids
     * @return list
     */
    List<AdminPermission> findByIdIn(Collection<Long> ids);
}

