package com.practice.solarmng.repository;


import com.practice.solarmng.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    Optional<List<ProjectEntity>> findByUserId(long userId);
}
