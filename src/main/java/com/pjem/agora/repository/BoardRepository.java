package com.pjem.agora.repository;

import com.pjem.agora.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {


    @Query("SELECT d FROM Board d \n" +
            "    WHERE d.mandateStart <= :endDate \n" +
            "      AND d.mandateEnd >= :startDate")
    List<Board>findByManagementPeriod(@Param("startDate") LocalDate startDate,
                                        @Param("endDate") LocalDate endDate);


}

