package poo.aula02_pacotes;

import java.util.Date;

/**
 * POO — Aula 02: Pacotes e Importações
 *
 * Conceitos:
 * - package: localização real da classe no projeto
 * - import: como trazer classes de outros pacotes
 * - Convenção de nomes de pacotes
 * - Nome simples vs nome qualificado
 *
 * Exercício do PDF: lista de amigos com dados de contato e endereço.
 */

// ---- Classe Contato ----
class Contato {
    private String email;
    private String whatsapp;
    private String instagram;

    public Contato(String email, String whatsapp, String instagram) {
        this.email = email;
        this.whatsapp = whatsapp;
        this.instagram = instagram;
    }

    public String getEmail()     { return email; }
    public String getWhatsapp()  { return whatsapp; }
    public String getInstagram() { return instagram; }
}

// ---- Classe Endereco ----
class Endereco {
    private String logradouro;
    private int numero;
    private String cidade;
    private String siglaEstado;

    public Endereco(String logradouro, int numero, String cidade, String siglaEstado) {
        this.logradouro  = logradouro;
        this.numero      = numero;
        this.cidade      = cidade;
        this.siglaEstado = siglaEstado;
    }

    public String getEnderecoCompleto() {
        return logradouro + ", " + numero + " — " + cidade + "/" + siglaEstado;
    }
}

// ---- Classe Amigo ----
class Amigo {
    private String nome;
    private String apelido;
    private Date   dataNascimento;
    private Contato contato;
    private Endereco endereco;

    public Amigo(String nome, String apelido, Date dataNascimento,
                 Contato contato, Endereco endereco) {
        this.nome            = nome;
        this.apelido         = apelido;
        this.dataNascimento  = dataNascimento;
        this.contato         = contato;
        this.endereco        = endereco;
    }

    public void apresentar() {
        System.out.println("Nome:       " + nome + " (" + apelido + ")");
        System.out.println("Email:      " + contato.getEmail());
        System.out.println("WhatsApp:   " + contato.getWhatsapp());
        System.out.println("Instagram:  @" + contato.getInstagram());
        System.out.println("Endereço:   " + endereco.getEnderecoCompleto());
        System.out.println("Nascimento: " + dataNascimento);
    }

    public String getNome() { return nome; }
    public Contato getContato() { return contato; }
}

// ---- Classe Principal ----
public class PacotesEImportacoes {

    public static void main(String[] args) {

        System.out.println("=== Pacotes e Importações ===\n");

        // Demonstrando import: java.util.Date importado no topo do arquivo
        // Sem o import, precisaríamos escrever o nome qualificado completo:
        //   java.util.Date dataNasc = new java.util.Date();
        Date hoje = new Date(); // graças ao 'import java.util.Date'

        // ========================
        // EXERCÍCIO: Lista de Amigos
        // ========================

        Amigo amigo1 = new Amigo(
            "Gleyson Sampaio",
            "Gley",
            new Date(631152000000L), // data simulada
            new Contato("gleyson@digytal.com.br", "(62) 99999-0001", "gleyson.dev"),
            new Endereco("Rua das Flores", 100, "Goiânia", "GO")
        );

        Amigo amigo2 = new Amigo(
            "Maria Fernanda",
            "Mafe",
            new Date(757382400000L),
            new Contato("mafe@email.com", "(11) 98888-0002", "mafe.tech"),
            new Endereco("Av. Paulista", 1000, "São Paulo", "SP")
        );

        Amigo amigo3 = new Amigo(
            "João Pedro",
            "JP",
            new Date(820454400000L),
            new Contato("joaopedro@email.com", "(21) 97777-0003", "jp.coder"),
            new Endereco("Rua do Ouvidor", 50, "Rio de Janeiro", "RJ")
        );

        Amigo[] amigos = {amigo1, amigo2, amigo3};

        System.out.println("Lista de Amigos:");
        System.out.println("=".repeat(40));

        for (Amigo amigo : amigos) {
            amigo.apresentar();
            System.out.println("-".repeat(40));
        }

        // Imprimindo informação aleatória de cada amigo
        System.out.println("\nInformações rápidas:");
        for (Amigo amigo : amigos) {
            System.out.println(amigo.getNome()
                + " tem o email " + amigo.getContato().getEmail());
        }

        // ========================
        // NOME QUALIFICADO vs SIMPLES
        // ========================
        System.out.println("\n=== Nome Simples vs Qualificado ===");
        System.out.println("Simples:     Date");
        System.out.println("Qualificado: java.util.Date");
        System.out.println("\nConvenção de nomes:");
        System.out.println("Comercial:    com.empresa");
        System.out.println("Governamental: gov.orgao");
        System.out.println("Código aberto: org.projeto");
    }
}
