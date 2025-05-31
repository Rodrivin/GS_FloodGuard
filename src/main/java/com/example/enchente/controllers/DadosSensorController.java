package com.example.enchente.controllers;

import com.example.enchente.models.Alerta;
import com.example.enchente.models.DadosSensor; // Importe a classe DadosSensor
import com.example.enchente.services.AlertaService;
import com.example.enchente.services.DadosSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sensores")
public class DadosSensorController { // Remova o parâmetro de tipo <DadosSensor>

    @Autowired
    private DadosSensorService dadosSensorService;
    @Autowired
    private AlertaService alertaService;

    @PostMapping
    public ResponseEntity<DadosSensor> receberDadosSensor(@RequestBody DadosSensor dadosSensor) {
        DadosSensor dadosSalvos = dadosSensorService.salvarDadosSensor(dadosSensor);
        // Simula a emissão de um alerta ao receber dados do sensor
        Alerta alertaGerado = alertaService.gerarAlerta(dadosSalvos);
        if (alertaGerado != null) {
            System.out.println("Alerta gerado: " + alertaGerado.getMensagem() + " (Nível: " + alertaGerado.getNivelRisco() + ")");
        }
        return new ResponseEntity<>(dadosSalvos, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DadosSensor>> listarTodosDadosSensores() {
        return new ResponseEntity<>(dadosSensorService.listarTodosDadosSensores(), HttpStatus.OK);
    }
}