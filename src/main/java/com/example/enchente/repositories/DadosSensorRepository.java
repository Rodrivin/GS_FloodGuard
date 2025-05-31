package com.example.enchente.repositories;

import com.example.enchente.models.DadosSensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosSensorRepository extends JpaRepository<DadosSensor, Long> {
    // Métodos adicionais de consulta podem ser adicionados aqui, se necessário
}