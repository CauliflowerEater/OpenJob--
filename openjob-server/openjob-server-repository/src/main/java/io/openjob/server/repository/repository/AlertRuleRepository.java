package io.openjob.server.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.openjob.server.repository.entity.AlertRule;


public interface AlertRuleRepository extends JpaRepository<AlertRule, Long> {

}
