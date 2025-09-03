package io.openjob.server.repository.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.openjob.server.repository.entity.AdminRole;


public interface AdminRoleRepository extends JpaRepository<AdminRole, Long> {
    /**
     * Find by ID In given list
     *
     * @param ids ids
     * @return list
     */
    List<AdminRole> findByIdIn(Collection<Long> ids);

}

