package com.example.enchente.services;

import com.example.enchente.models.Alerta;
import com.example.enchente.models.DadosSensor;
import com.example.enchente.repositories.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public Alerta gerarAlerta(DadosSensor dadosSensor) {
        String nivelRisco = determinarNivelRisco(dadosSensor.getNivelAgua());
        if (!"Baixo".equals(nivelRisco)) {
            Alerta alerta = new Alerta();
            alerta.setTimestamp(LocalDateTime.now());
            alerta.setNivelRisco(nivelRisco);
            alerta.setMensagem("Nível da água detectado como " + nivelRisco + ".");
            return alertaRepository.save(alerta);
        }
        return null;
    }

    private String determinarNivelRisco(Double nivelAgua) {
        if (nivelAgua > 10.0) {
            return "Alto";
        } else if (nivelAgua > 5.0) {
            return "Médio";
        } else {
            return "Baixo";
        }
    }

    public List<Alerta> listarTodosAlertas() {
        return alertaRepository.findAll();
    }
}