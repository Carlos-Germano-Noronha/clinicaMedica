package br.ufms.clinicamedica;

import java.time.LocalDate;
import java.util.List;
public class Medico extends Pessoa {

    private String crm;

    public Medico(String nome, String cpf, String crm) {
        this(nome, cpf, crm,  null, null, null);
    }

    public Medico(String nome, String cpf, String crm,  Endereco endereco, String telefone, LocalDate dataNascimento) {
        super(nome,  cpf, endereco, telefone, dataNascimento);

        this.setcrm(crm);
    }

    public void preencherReceita(Consulta consulta, String receita) {
        if (consulta == null) {
            throw new IllegalArgumentException("É necessário informar uma consulta");
        }
        consulta.setReceita(receita);
    }

    public void solicitarExames(Consulta consulta, List<String> exames) {
        if (consulta == null) {
            throw new IllegalArgumentException("É necessário informar uma consulta");
        }
        consulta.setExames(exames);
    }

    public String getCRM() {
        return crm;
    }
    public String getCrmFormatado() {
        int numero = Integer.parseInt(crm.substring(0, crm.length() - 2));
        return String.format("%06d-%s", numero, crm.substring(crm.length() - 2));
    }
    public void setcrm(String crm) {
        if (crm.matches("^0+$")) {
            throw new IllegalArgumentException("CRM inválido: não pode ser composto apenas por zeros");
        }
        if (crm == null || crm.isBlank()){
            throw new IllegalArgumentException("O CRM não pode ser nulo ou vazio");
        }
        if (!crm.matches("^\\d{4,10}$")) {
            throw new IllegalArgumentException("CRM inválido: deve conter apenas números, entre 4 e 10 dígitos");
        }
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Medico{nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", endereco=" + getEndereco() +
                ", telefone='" + getTelefone() + '\'' +
                ", dataNascimento=" + getDataNascimento() + '\'' +
                ", crm=" + crm +
                '}';
    }
}
