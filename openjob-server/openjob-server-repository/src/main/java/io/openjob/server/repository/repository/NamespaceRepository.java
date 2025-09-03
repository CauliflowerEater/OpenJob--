package io.openjob.server.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.openjob.server.repository.entity.Namespace;

/**
 * @author stelin swoft@qq.com
 * @since 1.0.0
 */
public interface NamespaceRepository extends JpaRepository<Namespace, Long> {
}
