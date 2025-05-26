package br.ufms.clinicamedica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {

//            ClinicaMedica s1 = new ClinicaMedica("veterinária", "");

//            Secretario secretario = new Secretario(
//                    "Kleber Kruger", //dá para cadastrar secretário
//                    "12345678909",
//                    null,
//                    "67991234567",
//                    LocalDate.of(1988, 12, 8),
//                    LocalDate.now(), 30000);
//////            ClinicaMedica clinica = new ClinicaMedica("Clínica Universitária", "");
//////            // Implemente seus testes aqui...
//            Medico m = new Medico( "Carlos Germano de Souza" , // dá para cadastrar médico
//                    "70603668143",
//                    "12345",
//                    "67999553934",
//                    LocalDate.of(1997, 2, 18),
//                    null);
//
//            System.out.println(m);
//            Paciente paciente = new Paciente("Carlos Germano", // dá para cadastrar paciente
//                    "70603668143",
//                    null,
//                    "67999553934",
//                     LocalDate.of(1997, 02, 18));
//////             Experimente cadastrar um secretário, médico, paciente, agendar uma consulta...
//////            System.out.println(paciente);
//            Consulta consulta = new Consulta(m,       //dá para criar consulta
//                    paciente,
//                    "Dor de cabeça e saudades",
//                    LocalDateTime.of(2025, 8, 14,10,30),
//                    35.00,
//                    "", null);
//////            System.out.println(consulta.getMedico());
//////            System.out.println(consulta.getPaciente());
////              System.out.println(consulta);
////            for(int i = 0; i<= 5; i++){                 //    Aqui fui testar se o gerador de codigo está funcionando e agendar consulta pelo secretário
////                Consulta consulta = secretario.agendarConsulta(paciente, m, "Gripe", LocalDateTime.of(2026, 8, 14, 10, 30), 35.50);
////                System.out.println(consulta);
////            secretario.alterarDadosPaciente(paciente, "novoNome Carlos",null, null, null );
////            System.out.println(paciente.getNome());
////            System.out.println(consulta);
////            }
////               secretario.receberPagamento(consulta, 34.50);  //conseguimos pagar, retornando troco, saldo devedor e pagamento total
//            m.preencherReceita(consulta, "Dipirona"); //preenche a receita
//            m.solicitarExames(consulta, List.of(" de sangue")); //dá para solicitar exames
//            consulta.encerrarConsulta();
//            System.out.println(consulta);
//            System.out.println(paciente.visualizarExames(consulta, paciente));
//            SolicitarConsulta solicitacao = new SolicitarConsulta(m, paciente, "Preguiçaaaa", LocalDateTime.of(2025,8,14,10,30), 40.00);
//            System.out.println(solicitacao);
//            Consulta consulta = secretario.agendarSolicitacoes(solicitacao);                //consigo agendar consulta solicitada pelo paciente
//            System.out.println(consulta);
//            clinica.adicionarSecretario(s1);
//            clinica.adicionarSecretario(s2);
//            for (Scretario s : clinica.getSecretarios()){
//                System.out.println(s.getNome(0));
//            }
//            clinica.getSecretarios().forEach(System.out.println);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
