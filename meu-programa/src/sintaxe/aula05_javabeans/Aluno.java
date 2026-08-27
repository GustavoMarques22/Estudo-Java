package sintaxe.aula05_javabeans;

/**
 * Aula 05 - Java Beans
 *
 * Conceitos:
 * - Atributos privados (private)
 * - Métodos getters (getNome, getIdade...)
 * - Métodos setters (setNome, setIdade...)
 * - Uso do 'this' para diferenciar atributo do parâmetro
 * - Construtores
 */
public class Aluno {

    // Atributos PRIVADOS — só acessíveis dentro da própria classe
    private String nome;
    private int idade;
    private double notaMedia;
    private boolean aprovado;

    // ========================
    // CONSTRUTORES
    // ========================

    // Construtor padrão (sem argumentos)
    public Aluno() {
    }

    // Construtor com argumentos — exige nome obrigatório
    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // ========================
    // GETTERS — obtêm o valor
    // ========================

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public boolean isAprovado() {
        // prefixo 'is' para booleanos, não 'get'
        return aprovado;
    }

    // ========================
    // SETTERS — definem o valor
    // ========================

    public void setNome(String nome) {
        this.nome = nome;   // 'this.nome' é o atributo; 'nome' é o parâmetro
    }

    public void setIdade(int idade) {
        if (idade < 0 || idade > 120) {
            System.out.println("Idade inválida: " + idade);
            return;
        }
        this.idade = idade;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
        this.aprovado = notaMedia >= 7.0; // atualiza aprovação automaticamente
    }

    // Método de comportamento
    public void exibirSituacao() {
        System.out.println("Aluno:      " + nome);
        System.out.println("Idade:      " + idade);
        System.out.println("Média:      " + notaMedia);
        System.out.println("Situação:   " + (aprovado ? "Aprovado ✓" : "Reprovado ✗"));
    }
}
