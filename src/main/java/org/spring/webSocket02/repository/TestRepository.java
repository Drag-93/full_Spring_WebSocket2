package org.spring.webSocket02.repository;

import org.spring.webSocket02.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
    Optional<TestEntity> findByName(String name);
}
