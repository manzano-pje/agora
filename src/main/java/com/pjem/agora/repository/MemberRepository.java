package com.pjem.agora.repository;

import com.pjem.agora.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Members, Long> {

    Optional<Members> findByNameContainingIgnoreCase(String name);
    Optional<Members> findByCpf(String cpf);

}
