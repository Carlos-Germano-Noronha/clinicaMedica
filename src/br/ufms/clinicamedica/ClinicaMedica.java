package br.ufms.clinicamedica;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;


public class ClinicaMedica {

    private String nome;
    private final String cnpj; // o CNPJ após inicializado não deve ser modificado
    // as listas também são "final" porque a referência não será modificada, isto é,
    // estas variáveis sempre apontarão para a mesma lista (isto é apenas uma boa prática)
    private final List<Medico> medicos;
    private final List<Secretario> secretarios;
    private final List<Paciente> pacientes;
    private final List<Consulta> consultas;

    public ClinicaMedica(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;

        this.medicos = new ArrayList<>();
        this.secretarios = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void adicionarMedico(Medico medico){
        if (medico == null){
            throw new IllegalArgumentException("O médico não pode ser nulo");
        } else if (medicos.contains(medico)){
            throw new IllegalArgumentException("Médico ja adicionado");
        }
        medicos.add(medico);
    }
    public void adicionarMedicos(Medico... medicos){
        for (Medico medico : medicos){
            adicionarMedico(medico);
        }
    }

    public void removerMedico(Medico medico){
        if (medico == null){
            throw new IllegalArgumentException("Médico nulo");
        } else if (!medicos.contains(medico)){
            throw new IllegalArgumentException("Médico não encontrado");
        }
        medico.desativar();
        if (!getConsultasPorMedico(medico).isEmpty()){
            medicos.remove(medico);
        }

        // E se o médico estiver consultas agendadas, o que acontece?
        // Implemente suas validações conforme achar necessário...
        // ...
        // Ao final, o médico deve ser removido da lista de médicos
    }
    public List<Medico> getMedicos() {
        // retorna uma cópia da lista de médicos para que o usuário não possa alterá-la
        return Collections.unmodifiableList(medicos);
    }

    public void adicionarSecretario (Secretario secretario){
        if (secretario == null){
            throw new IllegalArgumentException("Secretário nulo");
        } else if (secretarios.contains(secretario)){
            throw new IllegalArgumentException("O secretário já foi adicionado");
        }
        secretarios.add(secretario);
    }
    public void adicionarSecretarios(Secretario... secretarios) {
        for (Secretario secretario : secretarios) {
            adicionarSecretario(secretario);
        }
    }
    public void removerSecretario(Secretario secretario) {
        if (secretario == null) {
            throw new IllegalArgumentException("Secretario nulo");
        } else if (!secretarios.contains(secretario)) {
            throw new IllegalArgumentException("Secretario não encontrado");
        }
        secretarios.remove(secretario);
    }
    public List<Secretario> getSecretarios() {
        // retorna uma cópia da lista de secretários para que o usuário não possa alterá-la
        return Collections.unmodifiableList(secretarios);
    }
    public void adicionarPaciente(Paciente paciente) {
        // Implemente aqui...
        if (paciente == null){
            throw new IllegalArgumentException("Paciente nulo");
        } else if(pacientes.contains(paciente)){
            throw new IllegalArgumentException("o paciente já foi adicionado");
        }
        pacientes.add(paciente);
    }
    public void adicionarPacientes(Paciente... pacientes) {
        // Implemente aqui...
        for (Paciente paciente : pacientes){
            adicionarPaciente(paciente);
        }
    }
    public void removerPaciente(Paciente paciente) {
        // Implemente aqui...
        if (paciente == null){
            throw new IllegalArgumentException("voce precisa passar um paciente");
        } else if (!pacientes.contains(paciente)) {
            throw new IllegalArgumentException("Paciente não encontrado");
        }
        pacientes.remove(paciente);
        }
    public List<Paciente> getPacientes() {
        return Collections.unmodifiableList(pacientes);
    }

    public Consulta agendarConsulta(Paciente paciente, Medico medico, String sintomas, LocalDateTime dataHora) {
        // Implemente aqui...
        if ( paciente == null || !pacientes.contains(paciente)){
            throw new IllegalArgumentException("Informe um paciente válido");
        } else if (medico == null || !medicos.contains(medico)){
            throw new IllegalArgumentException("Informe um médico válido");
        } else if (sintomas == null || sintomas.isBlank()){
            throw new IllegalArgumentException("Informe os sintomas");
        } else if (!medico.isAtivo()) {
            throw new IllegalArgumentException("Esse médico não aceita mais consultas");
        }
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico) &&  consulta.getDataHora().equals(dataHora)) {
                throw new IllegalArgumentException("O médico ja tem consulta agendada para esse horario!");
            }   if (consulta.getPaciente().equals(paciente) && consulta.getDataHora().equals(dataHora)){
                throw new IllegalArgumentException("o paciente já tem consulta agendada para esse horario!");
            }
        }
        Consulta consulta = new Consulta(medico, paciente, sintomas, dataHora);
        consultas.add(consulta);
        return consulta;
    }

    public Consulta buscarConsulta(long codigo) {
        for (Consulta consulta : consultas) {
            if (consulta.getCodigo() == codigo) {
                return consulta;
            }
        }
        return null;
    }
    /**
     * Retorna uma lista com todas as consultas de um determinado médico.
     *
     * @param medico médico
     * @return lista com todas as consultas de um determinado médico
     */
    public List<Consulta> getConsultasPorMedico(Medico medico) {
        return getConsultasPorMedico(medico, null);
    }

    /**
     * Retorna uma lista com todas as consultas de um determinado médico.
     *
     * @param medico médico
     * @return lista com todas as consultas do médico
     */
    public List<Consulta> getConsultasPorMedico(Medico medico, LocalDate data) {
        List<Consulta> lista = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico) &&
                    // Se não informou uma data específica, então retorne todas as consultas deste médico...
                    // Caso tenha informado uma data específica, adicione somente as consultas nesta data
                    (data == null || consulta.getDataHora().toLocalDate().equals(data))) {
                lista.add(consulta);
            }
        }
        return lista;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
    public SolicitarConsulta solicitarConsulta(Medico medico, Paciente paciente, String sintomas, LocalDateTime dataHoraSolicitada){
        if (dataHoraSolicitada == null) {
            throw new IllegalArgumentException("a data não pode ser nula");
        } else if (medico == null || !medicos.contains(medico)){
            throw new IllegalArgumentException("Por favor, informe o médico desejado!");
        } else if (paciente == null || !pacientes.contains(paciente)){
            throw new IllegalArgumentException("Por favor, informe os dados do paciente!");
        } else if (sintomas == null || sintomas.isBlank()) {
            throw new IllegalArgumentException("Por favor, informe os sintomas!");
        }
        for (Consulta consulta : consultas){
            if (consulta.getMedico().equals(medico) && consulta.getDataHora().equals(dataHoraSolicitada)){
                throw new IllegalArgumentException(" O médico ja tem consulta agendada para esse dia nesse horario!");
            } else if (consulta.getPaciente().equals(paciente) && consulta.getDataHora().equals(dataHoraSolicitada)){
                throw new IllegalArgumentException("O paciente já tem uma consulta agendada para esse horario");
            }
        }
        return new SolicitarConsulta(medico, paciente, sintomas, dataHoraSolicitada);
    }

    public void finalizarConsulta(Consulta consulta, Medico medico){
        if(consulta == null || !consultas.contains(consulta)){
            throw new IllegalArgumentException("Consulta invalida");
        } if (!consulta.isAtendida()){
            throw new IllegalArgumentException("O medico precisa informar a receita e solicitar exames");
        } if (!medico.isAtivo()){
            if (getConsultasPorMedico(medico).isEmpty()) {
                removerMedico(medico);
             }
            }
        }

//    public Consulta agendarSolicitacoes(SolicitarConsulta solicitarConsulta){
//        if (solicitarConsulta == null){
//            throw new IllegalArgumentException("Não há solicitações");
//        }
//        Medico medico = solicitarConsulta.getMedico();
//        Paciente paciente = solicitarConsulta.getPaciente();
//        String sintomas = solicitarConsulta.getSintomas();
//        LocalDateTime dataHora = solicitarConsulta.getDataHoraSolicitada();
//        double valor = solicitarConsulta.getValor();
//        Consulta consulta = new Consulta(medico, paciente,sintomas,dataHora);
//        return consulta;
//    }
//    public Paciente alterarDadosPaciente(Paciente paciente, String alterarNome, String alterarTelefone, Endereco alterarEndreco, LocalDate alterarDataNascimento) {
//        if(alterarNome != null){
//            paciente.setNome(alterarNome);
//        }
//        if (alterarTelefone != null){
//            paciente.setTelefone(alterarTelefone);
//        }
//        if (alterarEndreco != null){
//            paciente.setEndereco(alterarEndreco);
//        }
//        if (alterarDataNascimento != null){
//            paciente.setDataNascimento(alterarDataNascimento);
//        }
//        System.out.println("Dados do paciente alterados!");
//        return paciente;
//    }
//    public void receberPagamento(Consulta consulta, double valorPago) {
//        double valorPagar = consulta.getValor();
//        if (valorPagar == valorPago) {
//            System.out.println("Pagamento recebido: R$ " + valorPago); //aqui é na parte visual, modificar quando possivel.
//        } else if(valorPago < valorPagar){
//            System.out.println("Saldo devedor = R$ " + (valorPagar - valorPago) );
//        } else {
//            System.out.println("Troco = R$ " + (valorPago - valorPagar));
//        }
//    }
}

