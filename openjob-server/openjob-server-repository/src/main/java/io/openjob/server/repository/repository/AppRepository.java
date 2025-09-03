package io.openjob.server.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.openjob.server.repository.entity.App;


public interface AppRepository extends JpaRepository<App, Long> {

    /**
     * Find by name.
     *
     * @param name name
     * @return App
     */
    App findAppByName(String name);

    /**
     * Find first by namespace id
     *
     * @param namespaceId namespaceId
     * @param deleted     deleted
     * @return App
     */
    App findFirstByNamespaceIdAndDeleted(Long namespaceId, Integer deleted);

    /**
     * Get count by namespace id
     *
     * @param namespaceId namespaceId
     * @param deleted     deleted
     * @return Long
     */
    Long countByNamespaceIdAndDeleted(Long namespaceId, Integer deleted);
}