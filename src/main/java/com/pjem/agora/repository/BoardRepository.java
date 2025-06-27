package com.pjem.agora.repository;

import com.pjem.agora.model.Board;
import com.pjem.agora.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByAssociates(Members Associate);

    @Query("SELECT d from Board d JOIN FETCH d.members")
    List<Board> findAllWithAssociates();

    @Query("SELECT d FROM Board d Where d.startDate <= :startDate AND d.finalDate <= :endDate")
    List<Board> findAllDirectionByPeriod(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDaet
    );
}


