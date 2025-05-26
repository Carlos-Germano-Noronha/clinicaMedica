package br.ufms.clinicamedica;

import java.time.LocalDateTime;
import java.util.List;

public class Consulta {

    private final long codigo;
    private final Medico medico;
    private final Paciente paciente;
    private String sintomas;
    private LocalDateTime dataHora;
    private double valor;
    private String receita;
    private List<String> exames;

    public Consulta(Medico medico, Paciente paciente, String sintomas, LocalDateTime dataHora, double valor) {
        this.codigo = ++gerarCodigo;
        this.medico = medico;
        this.paciente = paciente;
        setSintomas(sintomas);
        setDataHora(dataHora);
        setValor(valor);
        setReceita(receita);
        setExames(exames);
    }
    public Consulta (Medico medico, Paciente paciente, String sintomas, LocalDateTime dataHora, double valor, String receita, List<String> exames){
        this.codigo = ++gerarCodigo;
        this.medico = medico;
        this.paciente = paciente;
        setSintomas(sintomas);
        setDataHora(dataHora);
        setValor(valor);
        setReceita(receita);
        setExames(exames);
    }
    public void encerrarConsulta(){
        if (receita == null || receita.trim().isEmpty()){
            throw new IllegalArgumentException("Por favor, informe a receita");
        }
        if (exames.isEmpty()){
            throw new IllegalArgumentException("Por favor, solicite os exames");
        }
    }
    private static long gerarCodigo = 0;
    public long getCodigo() {
        return codigo;
    }

    public Medico getMedico() {
        if(medico == null){
            throw new IllegalArgumentException("É necessário escolher um médico");
        }else {
            return medico;
        }
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        if (sintomas == null || sintomas.trim().isEmpty()){
            throw new IllegalArgumentException("Por favor, informe um sintoma");
        }
        this.sintomas = sintomas;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        if (dataHora.isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("Voce precisa escolher uma data/hora futura.");
        }
        this.dataHora = dataHora;

    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public void setExames(List<String> exames) {
        this.exames = (exames == null || exames.isEmpty()) ? List.of() : exames;
    }

    public List<String> getExames() {
        return (exames == null || exames.isEmpty()) ? List.of("Nenhum exame informado") : List.copyOf(exames);
    }
}
