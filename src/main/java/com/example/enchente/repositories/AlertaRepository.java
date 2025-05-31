package com.example.enchente.repositories;

import com.example.enchente.models.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
    // Métodos adicionais de consulta podem ser adicionados aqui, se necessário
}