package controlefluxo.aula02_repeticao;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Controle de Fluxo — Aula 02: Estruturas de Repetição
 *
 * Conceitos:
 * - for
 * - for-each
 * - while
 * - do-while
 * - break e continue
 */
public class Repeticao {

    public static void main(String[] args) {

        // ========================
        // 1. FOR
        // ========================
        System.out.println("=== FOR ===");

        // Exemplo clássico: contar carneirinhos
        System.out.println("Joãozinho contando carneirinhos:");
        for (int carneirinhos = 1; carneirinhos <= 5; carneirinhos++) {
            System.out.println(carneirinhos + " carneirinho(s)... 💤");
        }

        // Iterando sobre array com for tradicional
        System.out.println("\nAlunos (for com índice):");
        String[] alunos = {"Felipe", "Jonas", "Julia", "Marcos"};
        for (int i = 0; i < alunos.length; i++) {
            System.out.println("Índice " + i + " → " + alunos[i]);
        }

        // ========================
        // 2. FOR-EACH
        // ========================
        System.out.println("\n=== FOR-EACH ===");

        System.out.println("Alunos (for-each):");
        for (String aluno : alunos) {
            System.out.println("→ " + aluno);
        }

        // ========================
        // 3. BREAK E CONTINUE
        // ========================
        System.out.println("\n=== BREAK ===");
        System.out.println("Imprime até encontrar o número 3 (break):");
        for (int numero = 1; numero <= 5; numero++) {
            if (numero == 3) break;              // para o loop inteiro
            System.out.println(numero);
        }

        System.out.println("\n=== CONTINUE ===");
        System.out.println("Pula o número 3 (continue):");
        for (int numero = 1; numero <= 5; numero++) {
            if (numero == 3) continue;           // pula só essa iteração
            System.out.println(numero);
        }

        // ========================
        // 4. WHILE
        // ========================
        System.out.println("\n=== WHILE ===");
        System.out.println("Anya gastando a mesada de R$20:");

        double mesada = 20.0;
        while (mesada > 0) {
            double valorDoce = ThreadLocalRandom.current().nextDouble(2, 8);
            valorDoce = Math.round(valorDoce * 100.0) / 100.0; // 2 casas decimais
            if (valorDoce > mesada) valorDoce = mesada;
            System.out.printf("Doce R$ %.2f adicionado. Mesada restante: R$ %.2f%n",
                    valorDoce, mesada - valorDoce);
            mesada -= valorDoce;
        }
        System.out.println("Mesada zerada! Anya gastou tudo em doces. 🍬");

        // ========================
        // 5. DO-WHILE
        // ========================
        System.out.println("\n=== DO-WHILE ===");
        System.out.println("Joãozinho ligando para o amigo:");

        System.out.println("Discando...");
        do {
            System.out.println("Telefone tocando...");
        } while (naoAtendeu());
        System.out.println("Alô!!!");

        // ========================
        // 6. EXERCÍCIO PROCESSO SELETIVO (Cases 2, 3 e 4 do PDF)
        // ========================
        System.out.println("\n=== Processo Seletivo: Seleção de Candidatos ===");

        String[] candidatos = {
            "Felipe", "Márcia", "Julia", "Paulo", "Augusto",
            "Mônica", "Fabricio", "Mirela", "Daniela", "Jorge"
        };

        double salarioBase = 2000.0;

        // Case 2: selecionar até 5 candidatos com salário <= base
        System.out.println("Candidatos selecionados:");
        String[] selecionados = new String[5];
        int contadorSelecionados = 0;

        for (String candidato : candidatos) {
            if (contadorSelecionados >= 5) break;

            double salarioPretendido = valorAleatorio();
            if (salarioPretendido <= salarioBase) {
                selecionados[contadorSelecionados] = candidato;
                contadorSelecionados++;
                System.out.println("✔ " + candidato + " (R$" + String.format("%.2f", salarioPretendido) + ")");
            } else {
                System.out.println("✗ " + candidato + " (R$" + String.format("%.2f", salarioPretendido) + " — fora do budget)");
            }
        }

        // Case 3: imprimir lista final
        System.out.println("\nLista final para o RH:");
        for (int i = 0; i < contadorSelecionados; i++) {
            System.out.println((i + 1) + ". " + selecionados[i]);
        }

        // Case 4: tentar contato com até 3 tentativas
        System.out.println("\nRH entrando em contato:");
        for (int i = 0; i < contadorSelecionados; i++) {
            String candidato = selecionados[i];
            boolean contatoRealizado = false;

            for (int tentativa = 1; tentativa <= 3; tentativa++) {
                if (atendeu()) {
                    System.out.println("CONSEGUIMOS CONTATO COM " + candidato
                            + " APÓS " + tentativa + " TENTATIVA(S)");
                    contatoRealizado = true;
                    break;
                }
            }

            if (!contatoRealizado) {
                System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato);
            }
        }
    }

    // Simula salário pretendido aleatório entre R$1800 e R$2200
    private static double valorAleatorio() {
        return Math.round(ThreadLocalRandom.current().nextDouble(1800, 2200) * 100.0) / 100.0;
    }

    // Simula se o candidato atende (1 em 3 de chance)
    private static boolean atendeu() {
        return new Random().nextInt(3) == 1;
    }

    // Simula se o telefone ainda está tocando (não atendeu)
    private static boolean naoAtendeu() {
        boolean atendeu = new Random().nextInt(3) == 1;
        System.out.println("Atendeu? " + atendeu);
        return !atendeu;
    }
}
