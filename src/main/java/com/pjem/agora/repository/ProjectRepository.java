package com.pjem.agora.repository;

import com.pjem.agora.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long> {
    Optional<Projects> findByName(String name);
}
