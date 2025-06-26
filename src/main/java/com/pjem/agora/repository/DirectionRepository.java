package com.pjem.agora.repository;

import com.pjem.agora.model.Associates;
import com.pjem.agora.model.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long> {

    Optional<Direction> findByAssociates(Associates Associate);

    @Query("SELECT d from Direction d JOIN FETCH d.associates")
    List<Direction> findAllWithAssociates();

    @Query("SELECT d FROM Direction d Where d.startDate <= :startDate AND d.finalDate <= :endDate")
    List<Direction> findAllDirectionByPeriod(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDaet
    );
}


