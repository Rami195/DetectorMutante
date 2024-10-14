package com.example.parcialds.repositories;

import com.example.parcialds.entities.ADN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ADNRepository extends JpaRepository<ADN,Long> {
    Optional<ADN> findByDna(String dna);
    long countByIsMutant(Boolean isMutant);
}
