package com.pjem.agora.repository;

import com.pjem.agora.model.Projects;
import com.pjem.agora.record.ProjectRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository

public interface ProjectRepository extends JpaRepository<Projects, Long> {
//    Projects  findByName(String name);
    Optional<Projects> findByName(String name);

    @Query(value = "SELECT p FROM Projects p WHERE p.startDate BETWEEN :startDate AND :endDate ORDER BY p.startDate ASC")
    List<Projects> findByPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
