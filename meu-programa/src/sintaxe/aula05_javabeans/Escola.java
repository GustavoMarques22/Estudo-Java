package sintaxe.aula05_javabeans;

/**
 * Classe principal da Aula 05.
 * Demonstra o uso de getters, setters e construtores da classe Aluno.
 */
public class Escola {

    public static void main(String[] args) {

        System.out.println("=== Java Beans - Getters e Setters ===\n");

        // ---- Criando com construtor padrão + setters ----
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Maria Oliveira");
        aluno1.setIdade(20);
        aluno1.setNotaMedia(8.5);

        System.out.println("--- Aluno 1 ---");
        aluno1.exibirSituacao();

        // ---- Criando com construtor que exige nome e idade ----
        Aluno aluno2 = new Aluno("Carlos Souza", 22);
        aluno2.setNotaMedia(5.0);

        System.out.println("\n--- Aluno 2 ---");
        aluno2.exibirSituacao();

        // ---- Testando validação do setter ----
        Aluno aluno3 = new Aluno("Ana Lima", 18);
        aluno3.setIdade(-5);    // inválido, não será aplicado
        aluno3.setNotaMedia(7.0);

        System.out.println("\n--- Aluno 3 ---");
        aluno3.exibirSituacao();

        // ---- Acessando valores com getters ----
        System.out.println("\n=== Usando Getters ===");
        System.out.println("Nome via getNome():       " + aluno1.getNome());
        System.out.println("Média via getNotaMedia(): " + aluno1.getNotaMedia());
        System.out.println("Aprovado via isAprovado(): " + aluno1.isAprovado());
    }
}
