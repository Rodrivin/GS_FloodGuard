package com.example.enchente.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class DadosSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sensorId; // Identificador único do sensor
    private LocalDateTime timestamp;
    private Double nivelAgua;
    private Double temperatura;
    private Double umidade;

    // Construtores
    public DadosSensor() {
    }

    public DadosSensor(String sensorId, LocalDateTime timestamp, Double nivelAgua, Double temperatura, Double umidade) {
        this.sensorId = sensorId;
        this.timestamp = timestamp;
        this.nivelAgua = nivelAgua;
        this.temperatura = temperatura;
        this.umidade = umidade;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(Double nivelAgua) {
        this.nivelAgua = nivelAgua;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getUmidade() {
        return umidade;
    }

    public void setUmidade(Double umidade) {
        this.umidade = umidade;
    }
}