package br.ufms.clinicamedica;

import java.time.LocalDateTime;

public class SolicitarConsulta {
    private Medico medico;
    private Paciente paciente;
    private String sintomas;
    private LocalDateTime dataHoraSolicitada;
    private double valor;

    public SolicitarConsulta(Medico medico, Paciente paciente, String sintomas, LocalDateTime dataHoraSolicitada, double valor){
        if (medico == null || paciente == null) {
            throw new IllegalArgumentException("Médico e paciente devem ser informados.");
        }
        if (sintomas == null || sintomas.trim().isEmpty()) {
            throw new IllegalArgumentException("Sintomas devem ser informados.");
        }
        if (dataHoraSolicitada.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data da consulta deve ser futura.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da consulta deve ser positivo.");
        }

        this.medico = medico;
        this.paciente = paciente;
        this.sintomas = sintomas;
        this.dataHoraSolicitada = dataHoraSolicitada;
        this.valor = valor;

    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        if (sintomas == null || sintomas.isEmpty()){
            throw new IllegalArgumentException("É necessário informas os sintomas!");
        }
        this.sintomas = sintomas.trim();
    }

    public LocalDateTime getDataHoraSolicitada() {
        return dataHoraSolicitada;
    }

    public void setDataHoraSolicitada(LocalDateTime dataHoraSolicitada) {
        if (dataHoraSolicitada == null || dataHoraSolicitada.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("Voce precisa escolher uma data futura");
        }
        this.dataHoraSolicitada = dataHoraSolicitada;
    }
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Solicitação de Consulta:\n" +
                "Médico: " + medico.getNome() + "\n" +
                "Paciente: " + paciente.getNome() + "\n" +
                "Sintomas: " + sintomas + "\n" +
                "Data/Hora: " + dataHoraSolicitada + "\n" +
                "Valor: R$ " + valor;
    }
}
