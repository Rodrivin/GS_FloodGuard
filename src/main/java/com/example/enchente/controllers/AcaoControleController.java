package com.example.enchente.controllers;

import com.example.enchente.models.AcaoControle;
import com.example.enchente.services.AcaoControleService;
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
@RequestMapping("/controle")
public class AcaoControleController {

    @Autowired
    private AcaoControleService acaoControleService;

    @PostMapping("/barreira/ativar")
    public ResponseEntity<AcaoControle> ativarBarreira(@RequestBody String detalhes) {
        AcaoControle acao = acaoControleService.ativarBarreira(detalhes);
        return new ResponseEntity<>(acao, HttpStatus.CREATED);
    }

    @PostMapping("/historico")
    public ResponseEntity<AcaoControle> registrarHistorico(@RequestBody String descricao) {
        AcaoControle acao = acaoControleService.registrarHistorico(descricao);
        return new ResponseEntity<>(acao, HttpStatus.CREATED);
    }

    @GetMapping("/acoes")
    public ResponseEntity<List<AcaoControle>> listarTodasAcoesControle() {
        return new ResponseEntity<>(acaoControleService.listarTodasAcoesControle(), HttpStatus.OK);
    }
}