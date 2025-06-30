package com.pjem.agora.repository;

import com.pjem.agora.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

//    Optional<Board> findByMember(Members Member);

//    @Query("SELECT d from Board d JOIN FETCH d.memberName AND d.isActive := true")
//    Optional<Board> findAllMembersByCpf(String cpf);



    @Query("SELECT d FROM Board d \n" +
            "    WHERE d.mandateStart <= :endDate \n" +
            "      AND d.mandateEnd >= :startDate")
    Optional<Board>findByManagementPeriod(@Param("startDate") LocalDate startDate,
                                        @Param("endDate") LocalDate endDate);

    Optional<Board> findByMandateStartLessThanEqualAndMandateEndGreaterThanEqual(
            LocalDate endDate, LocalDate startDate);

}

