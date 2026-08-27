package poo.aula01_classes;

/**
 * POO — Aula 01: Classes, Objetos, Construtores e Enums
 *
 * Conceitos:
 * - Classe como molde / representação do mundo real
 * - Atributos (características) e Métodos (comportamentos)
 * - Instanciar objetos com 'new'
 * - Construtores padrão e parametrizados
 * - Enum: conjunto de objetos pré-definidos e imutáveis
 */

// ---- ENUM: Estado Civil ----
enum EstadoCivil {
    SOLTEIRO, CASADO, DIVORCIADO, VIUVO
}

// ---- ENUM: Estado Brasileiro (com atributos e métodos) ----
enum EstadoBrasileiro {
    SAO_PAULO("SP", "São Paulo"),
    RIO_JANEIRO("RJ", "Rio de Janeiro"),
    GOIAS("GO", "Goiás"),
    MINAS_GERAIS("MG", "Minas Gerais");

    private final String sigla;
    private final String nome;

    EstadoBrasileiro(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() { return sigla; }
    public String getNome()  { return nome; }
    public String getNomeMaiusculo() { return nome.toUpperCase(); }
}

// ---- CLASSE: Pessoa ----
class Pessoa {

    // Atributos
    String nome;
    int    idade;
    EstadoCivil estadoCivil;
    EstadoBrasileiro estado;

    // Construtor que exige nome obrigatório
    Pessoa(String nome) {
        this.nome = nome;
    }

    void apresentar() {
        System.out.println("Olá, sou " + nome
            + ", tenho " + idade + " anos"
            + (estado != null ? ", moro em " + estado.getNome() : "")
            + (estadoCivil != null ? " e sou " + estadoCivil.name().toLowerCase() : "") + ".");
    }
}

// ---- CLASSE: Carro (com equals e hashCode) ----
class Carro {

    String cor;
    String marca;
    String modelo;
    String chassi; // identificador único no mundo real

    Carro(String cor, String marca, String modelo, String chassi) {
        this.cor = cor;
        this.marca = marca;
        this.modelo = modelo;
        this.chassi = chassi;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + cor + ") — chassi: " + chassi;
    }
}

// ---- CLASSE PRINCIPAL ----
public class ClassesEObjetos {

    public static void main(String[] args) {

        // ========================
        // 1. INSTANCIANDO OBJETOS
        // ========================
        System.out.println("=== Instâncias de Pessoa ===");

        Pessoa carlos = new Pessoa("Carlos Henrique");
        carlos.idade = 30;
        carlos.estadoCivil = EstadoCivil.CASADO;
        carlos.estado = EstadoBrasileiro.GOIAS;

        Pessoa lucas = new Pessoa("Lucas Silva");
        lucas.idade = 25;
        lucas.estadoCivil = EstadoCivil.SOLTEIRO;
        lucas.estado = EstadoBrasileiro.SAO_PAULO;

        Pessoa diego = new Pessoa("Diego Felipe");
        diego.idade = 28;

        carlos.apresentar();
        lucas.apresentar();
        diego.apresentar();

        // ========================
        // 2. ENUM
        // ========================
        System.out.println("\n=== Enum EstadoBrasileiro ===");

        // Iterando todos os valores do enum
        for (EstadoBrasileiro uf : EstadoBrasileiro.values()) {
            System.out.println(uf.getSigla() + " — " + uf.getNomeMaiusculo());
        }

        // Selecionando um estado pelo nome do enum
        EstadoBrasileiro ufSelecionado = EstadoBrasileiro.valueOf("RIO_JANEIRO");
        System.out.println("\nEstado selecionado: " + ufSelecionado.getNome());

        // ========================
        // 3. REFERÊNCIAS E OBJETOS
        // ========================
        System.out.println("\n=== Referências vs Objetos ===");

        // Fábrica de carros: mesma cor/marca/modelo, mas objetos diferentes
        Carro carro1 = new Carro("branca", "Fiat", "Palio", "ABC-001");
        Carro carro2 = new Carro("branca", "Fiat", "Palio", "ABC-002");
        Carro carro3 = carro1; // referência ao MESMO objeto, não uma cópia!

        System.out.println("carro1: " + carro1);
        System.out.println("carro2: " + carro2);
        System.out.println("carro3 aponta para carro1: " + carro3);

        System.out.println("\ncarro1 == carro2 (referência): " + (carro1 == carro2)); // false
        System.out.println("carro1 == carro3 (referência): " + (carro1 == carro3)); // true (mesma ref)

        // ========================
        // 4. TIPOS DE CLASSE (model, service, etc.)
        // ========================
        System.out.println("\n=== Tipos de Classe (nomenclatura) ===");
        System.out.println("model      → representa entidade: Cliente, Pedido, Nota");
        System.out.println("service    → regras de negócio:   ClienteService");
        System.out.println("repository → banco de dados:      ClienteRepository");
        System.out.println("controller → comunicação HTTP:    ClienteController");
        System.out.println("util       → utilitários gerais:  FormatadorUtil");
    }
}
