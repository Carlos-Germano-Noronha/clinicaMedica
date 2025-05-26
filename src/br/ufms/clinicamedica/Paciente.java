package br.ufms.clinicamedica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Paciente extends Pessoa {

    public Paciente(String nome, String cpf){
        this(nome, cpf, null, null, null);
    }
    public Paciente(String nome, String cpf, Endereco endereco, String telefone, LocalDate dataNascimento){
    super(nome,cpf,endereco,telefone,dataNascimento);

    }
    public SolicitarConsulta solicitarConsulta(Medico medico, Paciente paciente, String sintomas, LocalDateTime dataHoraSolicitada, double valor){
        System.out.println("Consulta solicitada!");
        return new SolicitarConsulta( medico, paciente, sintomas, dataHoraSolicitada, valor);
    }

    public String visualizarReceitas(Consulta consulta, Paciente paciente) {
        if (consulta == null && paciente == null){
            throw new IllegalArgumentException("Consulta ou paciente não informado");
        }
        return consulta.getReceita();
    }

    public List<String> visualizarExames(Consulta consulta, Paciente paciente) {
        if (consulta == null && paciente == null){
            throw new IllegalArgumentException("Consulta ou paciente não informado");
        }
        return consulta.getExames();
    }

    @Override
    public String toString() {
        return "Paciente{nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", endereco=" + getEndereco() +
                ", telefone='" + getTelefone() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                '}';
    }
//    @Override
//    public String toString() {
//        return "Nome do paciente: " + getNome() +
//                "\nEndereço do paciente: " + (getEndereco() != null ? getNome() : "Não informado") +
//                "\nCPF do Paciente: " +  (getCpf() != null ? getCpf() : "Não informado") +
//                "\nTelefone do paciente: " + (getTelefone() != null ? getTelefone() : "Não informado") +
//                "\nData de nascimento do paciente: " + (getDataNascimento() != null ? getDataNascimento() : "Não informado") ;
//    }
}
