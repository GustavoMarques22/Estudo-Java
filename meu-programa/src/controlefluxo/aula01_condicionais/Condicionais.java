package controlefluxo.aula01_condicionais;

/**
 * Controle de Fluxo — Aula 01: Estruturas Condicionais
 *
 * Conceitos:
 * - if simples
 * - if/else composto
 * - if/else encadeado
 * - Operador ternário
 * - switch/case
 */
public class Condicionais {

    public static void main(String[] args) {

        // ========================
        // 1. IF SIMPLES
        // ========================
        System.out.println("=== IF Simples ===");

        double saldo = 25.0;
        double valorSolicitado = 17.0;

        if (valorSolicitado < saldo) {
            saldo = saldo - valorSolicitado;
            System.out.println("Saque realizado. Saldo: R$ " + saldo);
        }

        // ========================
        // 2. IF / ELSE
        // ========================
        System.out.println("\n=== IF / ELSE ===");

        int nota = 6;

        if (nota >= 7) {
            System.out.println("Nota " + nota + " → Aprovado");
        } else {
            System.out.println("Nota " + nota + " → Reprovado");
        }

        // ========================
        // 3. IF / ELSE encadeado
        // ========================
        System.out.println("\n=== IF / ELSE encadeado ===");

        int[] notas = {9, 6, 4};

        for (int n : notas) {
            if (n >= 7) {
                System.out.println("Nota " + n + " → Aprovado");
            } else if (n >= 5) {
                System.out.println("Nota " + n + " → Recuperação");
            } else {
                System.out.println("Nota " + n + " → Reprovado");
            }
        }

        // ========================
        // 4. TERNÁRIO
        // ========================
        System.out.println("\n=== Ternário ===");

        int nota2 = 8;
        String situacao = (nota2 >= 7) ? "Aprovado" : "Reprovado";
        System.out.println("Nota " + nota2 + " → " + situacao);

        // Ternário encadeado
        int nota3 = 5;
        String situacao2 = nota3 >= 7 ? "Aprovado"
                         : nota3 >= 5 ? "Recuperação"
                         : "Reprovado";
        System.out.println("Nota " + nota3 + " → " + situacao2);

        // ========================
        // 5. SWITCH / CASE
        // ========================
        System.out.println("\n=== Switch / Case ===");

        // Exemplo 1: tamanho de roupa
        String sigla = "M";

        switch (sigla) {
            case "P": {
                System.out.println(sigla + " → PEQUENO");
                break;
            }
            case "M": {
                System.out.println(sigla + " → MÉDIO");
                break;
            }
            case "G": {
                System.out.println(sigla + " → GRANDE");
                break;
            }
            default:
                System.out.println(sigla + " → TAMANHO INDEFINIDO");
        }

        // Exemplo 2: plano de operadora (sem break = efeito cascata intencional)
        System.out.println("\n--- Plano TURBO inclui tudo abaixo ---");
        String plano = "T";

        switch (plano) {
            case "T":
                System.out.println("✔ 5GB YouTube");
            case "M":
                System.out.println("✔ WhatsApp e Instagram grátis");
            case "B":
                System.out.println("✔ 100 minutos de ligação");
        }

        // Exemplo 3: dia da semana com switch em int
        System.out.println("\n--- Dia da semana ---");
        int dia = 3;

        switch (dia) {
            case 1: System.out.println("Segunda-feira"); break;
            case 2: System.out.println("Terça-feira");   break;
            case 3: System.out.println("Quarta-feira");  break;
            case 4: System.out.println("Quinta-feira");  break;
            case 5: System.out.println("Sexta-feira");   break;
            case 6: System.out.println("Sábado");        break;
            case 7: System.out.println("Domingo");       break;
            default: System.out.println("Dia inválido");
        }

        // ========================
        // 6. EXERCÍCIO PROCESSO SELETIVO (do PDF)
        // ========================
        System.out.println("\n=== Processo Seletivo ===");

        verificarCandidato(2000.0, 1900.0);  // salário base maior
        verificarCandidato(2000.0, 2000.0);  // salário igual
        verificarCandidato(1900.0, 2000.0);  // salário pretendido maior
    }

    static void verificarCandidato(double salarioBase, double salarioPretendido) {
        if (salarioBase > salarioPretendido) {
            System.out.println("Base R$" + salarioBase + " > Pretendido R$" + salarioPretendido
                + " → LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Base R$" + salarioBase + " = Pretendido R$" + salarioPretendido
                + " → LIGAR COM CONTRA PROPOSTA");
        } else {
            System.out.println("Base R$" + salarioBase + " < Pretendido R$" + salarioPretendido
                + " → AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
