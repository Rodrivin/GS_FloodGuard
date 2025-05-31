package com.example.enchente.repositories;

import com.example.enchente.models.AcaoControle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoControleRepository extends JpaRepository<AcaoControle, Long> {
    // Métodos adicionais de consulta podem ser adicionados aqui, se necessário
}