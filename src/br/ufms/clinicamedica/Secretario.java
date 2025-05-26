package br.ufms.clinicamedica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Secretario extends Pessoa {

    private LocalDate dataIngresso;
    private double salario;

    /**
     * Constrói um objeto Secretario informando apenas os atributos obrigatórios.
     *
     * @param nome    nome
     * @param cpf     cpf
     * @param salario salário
     */
    public Secretario(String nome, String cpf, double salario) {
        // este construtor chama o construtor abaixo para concentrar as inicializações em um mesmo lugar
        this(nome, cpf, null, null, null, null, salario);
    }

    /**
     * Cria um objeto Secretário especificando todos os campos.
     *
     * @param nome           nome
     * @param cpf            CPF
     * @param endereco       endereço
     * @param telefone       telefone
     * @param dataNascimento data de nascimento
     * @param dataIngresso   data de ingresso na clínica
     * @param salario        salário
     */
    public Secretario(String nome, String cpf, Endereco endereco, String telefone,
                      LocalDate dataNascimento, LocalDate dataIngresso, double salario) {
        // inicializa os atributos chamando os métodos setters que validam os valores
        super(nome, cpf);
        super.setEndereco(endereco);
        super.setTelefone(telefone);
        super.setDataNascimento(dataNascimento);
        this.setDataIngresso(dataIngresso);
        this.setSalario(salario);

    }
    public Consulta agendarConsulta(Paciente paciente, Medico medico, String sintomas, LocalDateTime datahora, double valor) {
        return new Consulta(medico, paciente, sintomas, datahora, valor);
    }
    public Consulta agendarSolicitacoes(SolicitarConsulta solicitarConsulta){
        if (solicitarConsulta == null){
            throw new IllegalArgumentException("Não há solicitações");
        }
        Medico medico = solicitarConsulta.getMedico();
        Paciente paciente = solicitarConsulta.getPaciente();
        String sintomas = solicitarConsulta.getSintomas();
        LocalDateTime dataHora = solicitarConsulta.getDataHoraSolicitada();
        double valor = solicitarConsulta.getValor();
        Consulta consulta = new Consulta(medico, paciente,sintomas,dataHora,valor);
        return consulta;
    }

    public Paciente alterarDadosPaciente(Paciente paciente, String alterarNome, String alterarTelefone, Endereco alterarEndreco, LocalDate alterarDataNascimento) {
        if(alterarNome != null){
            paciente.setNome(alterarNome);
        }
        if (alterarTelefone != null){
            paciente.setTelefone(alterarTelefone);
        }
        if (alterarEndreco != null){
            paciente.setEndereco(alterarEndreco);
        }
        if (alterarDataNascimento != null){
            paciente.setDataNascimento(alterarDataNascimento);
        }
        System.out.println("Dados do paciente alterados!");
        return paciente;
    }

    public void receberPagamento(Consulta consulta, double valorPago) {
        double valorPagar = consulta.getValor();
        if (valorPagar == valorPago) {
            System.out.println("Pagamento recebido: R$ " + valorPago);
        } else if(valorPago < valorPagar){
            System.out.println("Saldo devedor = R$ " + (valorPagar - valorPago) );
        } else {
            System.out.println("Troco = R$ " + (valorPago - valorPagar));
        }
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        if (dataIngresso != null && dataIngresso.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de ingresso inválida");
        }
        this.dataIngresso = dataIngresso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("O salário não pode ser negativo");
        }
        this.salario = salario;
    }


    @Override
    public String toString() {
        return "Secretario{nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", endereco=" + getEndereco() +
                ", telefone='" + getTelefone() + '\'' +
                ", dataNascimento=" + getDataNascimento() + '\'' +
                ", dataIngresso=" + dataIngresso + '\'' +
                ", salario='" + salario +
                '}';
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Secretario outro){
//            return this.cpf.equals(outro.Cpf());
//        } else if (obj instanceof Medico m) {
//            return this.cpf.equals(m.getCpf());
//        }
//        return false;
//    }
}
