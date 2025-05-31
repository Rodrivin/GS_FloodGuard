package com.example.enchente.services;

import com.example.enchente.models.DadosSensor;
import com.example.enchente.repositories.DadosSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DadosSensorService {

    @Autowired
    private DadosSensorRepository dadosSensorRepository;

    public DadosSensor salvarDadosSensor(DadosSensor dadosSensor) {
        dadosSensor.setTimestamp(LocalDateTime.now());
        return dadosSensorRepository.save(dadosSensor);
    }

    public List<DadosSensor> listarTodosDadosSensores() {
        return dadosSensorRepository.findAll();
    }
}