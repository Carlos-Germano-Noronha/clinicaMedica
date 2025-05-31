package br.ufms.clinicamedica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {

        ClinicaMedica clinica = new ClinicaMedica("Clinica", null);

        Paciente paciente = new Paciente("Carlos Germano", "70603668143");
        Medico m = new Medico( "Carlos Noronha", "70603668143", "559798");
        clinica.adicionarMedico(m);
        Medico n = new Medico( "Carlos Noronha", "00004048105", "598989");
        clinica.adicionarMedico(n);
        Paciente p = new Paciente("Carlos de souza", "00004048105");
        clinica.adicionarPacientes(p, paciente);
//        clinica.removerPaciente(p);
        Consulta c =  clinica.agendarConsulta( p, m,"Saudades dela", LocalDateTime.of(2026, 8, 14, 10, 30));
        clinica.removerMedico(m);
        clinica.finalizarConsulta(c,m);
//        clinica.agendarConsulta(p,m,"Saudades dela", LocalDateTime.of(2026, 7, 14, 10, 30) );
//        clinica.solicitarConsulta(m,p,"Saudades dela", LocalDateTime.of(2026, 8, 14, 10, 30));
        System.out.println(clinica.getConsultasPorMedico(m));
//        Secretario s = new Secretario("Carlos de souza", "70603668143", 3232.50);
//        clinica.adicionarSecretario(s);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
