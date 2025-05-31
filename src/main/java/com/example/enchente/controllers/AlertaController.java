package com.example.enchente.controllers;

import com.example.enchente.models.Alerta;
import com.example.enchente.services.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @GetMapping
    public ResponseEntity<List<Alerta>> listarTodosAlertas() {
        return new ResponseEntity<>(alertaService.listarTodosAlertas(), HttpStatus.OK);
    }
}