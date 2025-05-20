package com.pjem.agora.repository;

import com.pjem.agora.model.Associates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssociateRepository extends JpaRepository<Associates, Long> {

    Optional<Associates> findByNameContainingIgnoreCase(String name);

}
