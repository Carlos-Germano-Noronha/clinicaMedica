package br.ufms.clinicamedica;
import java.time.LocalDate;
//Statico pertence a classe, o que não é statico pertence a variavel
public class Pessoa {
    private String nome;
    private final String cpf;
    private Endereco endereco;
    private String telefone;
    private LocalDate dataNascimento;



    public Pessoa(String nome, String cpf ) {
        this(nome, cpf, null, null, null);

    }
    public Pessoa(String nome, String cpf, Endereco endereco, String telefone, LocalDate dataNascimento ){
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
        setDataNascimento(dataNascimento);

        this.cpf = validarCPF(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("O nome não pode ser nulo");
        }
        nome = nome.trim(); // elimina espaços adicionais no início ou final da string
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("O nome pode ser em branco");
        } else if (!nome.matches("^[A-Za-zÀ-ÖØ-öø-ÿ'\\-\\s]+$")) {
            throw new IllegalArgumentException("O nome possui caracteres inválidos: " + nome);
        } else if (nome.split(" ").length < 2) {
            throw new IllegalArgumentException("O nome está incompleto. Informe o sobrenome");
        } else if (nome.length() < 3 || nome.length() > 60) {
            throw new IllegalArgumentException("O nome deve ter de 3 a 60 caracteres");
        }
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        telefone = telefone != null ? telefone.trim() : null;
        if (telefone != null && !telefone.matches("^(\\d{2}9\\d{8}|\\d{2}[1-8]\\d{7})$")) {
            throw new IllegalArgumentException("Telefone inválido. Informe somente dígitos (com DDD)");
        }
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento != null) {
            if (dataNascimento.isBefore(LocalDate.now().minusYears(150)) ||
                    dataNascimento.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Data de nascimento inválida");
            }
        }
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    private static String validarCPF(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("CPF nulo");
        }
        cpf = cpf.trim();
        if (!cpf.matches("\\d{11}") || cpf.chars().distinct().count() == 1) {
            throw new IllegalArgumentException("CPF inválido");
        }

        int[] peso1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] peso2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma1 = 0, soma2 = 0;
        for (int i = 0; i < 9; i++) {
            int dig = Character.getNumericValue(cpf.charAt(i));
            soma1 += dig * peso1[i];
            soma2 += dig * peso2[i];
        }
        int dig1 = soma1 % 11 < 2 ? 0 : 11 - (soma1 % 11);
        soma2 += dig1 * peso2[9];
        int dig2 = soma2 % 11 < 2 ? 0 : 11 - (soma2 % 11);
        if (dig1 != Character.getNumericValue(cpf.charAt(9)) || dig2 != Character.getNumericValue(cpf.charAt(10))) {
            throw new IllegalArgumentException("CPF inválido");
        }
        return cpf;
    }
    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Pessoa pessoa)) return false;

        return cpf.equals(pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }

    @Override
    public String toString() {
        return "Usuario{nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco=" + endereco +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
