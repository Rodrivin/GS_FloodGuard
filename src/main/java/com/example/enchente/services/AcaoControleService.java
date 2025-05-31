package com.example.enchente.services;

import com.example.enchente.models.AcaoControle;
import com.example.enchente.repositories.AcaoControleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AcaoControleService {

    @Autowired
    private AcaoControleRepository acaoControleRepository;

    public AcaoControle ativarBarreira(String detalhes) {
        AcaoControle acao = new AcaoControle();
        acao.setTimestamp(LocalDateTime.now());
        acao.setTipoAcao("Ativação de barreira");
        acao.setDetalhes(detalhes);
        return acaoControleRepository.save(acao);
    }

    public AcaoControle registrarHistorico(String descricao) {
        AcaoControle acao = new AcaoControle();
        acao.setTimestamp(LocalDateTime.now());
        acao.setTipoAcao("Registro de histórico");
        acao.setDetalhes(descricao);
        return acaoControleRepository.save(acao);
    }

    public List<AcaoControle> listarTodasAcoesControle() {
        return acaoControleRepository.findAll();
    }
}