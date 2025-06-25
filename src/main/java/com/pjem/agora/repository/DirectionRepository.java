package com.pjem.agora.repository;

import com.pjem.agora.model.Associates;
import com.pjem.agora.model.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long> {

    Optional<Direction> findByAssociates(Associates Associate);

    @Query("SELECT d from Direction d JOIN FETCH d.associates")
    List<Direction> findAllWithAssociates();
}
