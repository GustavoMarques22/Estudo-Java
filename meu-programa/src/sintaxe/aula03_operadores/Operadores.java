package sintaxe.aula03_operadores;

/**
 * Aula 03 - Operadores
 *
 * Conceitos:
 * - Operadores de Atribuição (=, +=, -=, *=, /=)
 * - Operadores Aritméticos (+, -, *, /, %)
 * - Operadores Relacionais (==, !=, >, <, >=, <=)
 * - Operadores Unários (++, --, !, +, -)
 * - Operador Ternário (? :)
 * - Operadores Lógicos (&&, ||)
 */
public class Operadores {

    public static void main(String[] args) {

        // ========================
        // 1. ATRIBUIÇÃO
        // ========================
        System.out.println("=== Operadores de Atribuição ===");

        int n1 = 10;
        int n2 = 5;

        System.out.println("n1 = " + n1 + " | n2 = " + n2);

        n2 += n1;   // n2 = n2 + n1 = 15
        System.out.println("n2 += n1 → " + n2);

        n2 -= 3;    // n2 = n2 - 3 = 12
        System.out.println("n2 -= 3  → " + n2);

        n2 *= 2;    // n2 = n2 * 2 = 24
        System.out.println("n2 *= 2  → " + n2);

        n2 /= 4;    // n2 = n2 / 4 = 6
        System.out.println("n2 /= 4  → " + n2);

        // ========================
        // 2. ARITMÉTICOS
        // ========================
        System.out.println("\n=== Operadores Aritméticos ===");

        double soma          = 10.5 + 15.7;
        int subtracao        = 113 - 25;
        int multiplicacao    = 20 * 7;
        int divisao          = 15 / 3;
        int modulo           = 18 % 5;     // resto da divisão: 18/5 = 3 resto 3
        double resultado     = (10 * 7) + (20.0 / 4);

        System.out.println("10.5 + 15.7  = " + soma);
        System.out.println("113 - 25     = " + subtracao);
        System.out.println("20 * 7       = " + multiplicacao);
        System.out.println("15 / 3       = " + divisao);
        System.out.println("18 % 5       = " + modulo + " (resto)");
        System.out.println("(10*7)+(20/4)= " + resultado);

        // ATENÇÃO: + com String faz concatenação!
        System.out.println("\n=== Concatenação com String ===");
        String nomeCompleto = "Linguagem" + " " + "Java";
        System.out.println(nomeCompleto);

        // Cuidado com a ordem!
        System.out.println(1 + 1 + 1 + "1");    // 31  (soma os ints primeiro)
        System.out.println(1 + "1" + 1 + 1);    // 1111 (vira string depois do "1")
        System.out.println("1" + (1 + 1 + 1));  // 13  (parênteses somam primeiro)

        // ========================
        // 3. RELACIONAIS
        // ========================
        System.out.println("\n=== Operadores Relacionais ===");

        int numero1 = 10;
        int numero2 = 20;

        System.out.println("numero1 = " + numero1 + " | numero2 = " + numero2);
        System.out.println("numero1 == numero2 → " + (numero1 == numero2));
        System.out.println("numero1 != numero2 → " + (numero1 != numero2));
        System.out.println("numero1 >  numero2 → " + (numero1 > numero2));
        System.out.println("numero1 <  numero2 → " + (numero1 < numero2));
        System.out.println("numero1 >= numero2 → " + (numero1 >= numero2));
        System.out.println("numero1 <= numero2 → " + (numero1 <= numero2));

        // ========================
        // 4. UNÁRIOS
        // ========================
        System.out.println("\n=== Operadores Unários ===");

        int numero = 5;
        System.out.println("numero = " + numero);
        System.out.println("-numero = " + (-numero));   // negativo

        // ATENÇÃO: posição do ++ importa!
        System.out.println("\nnumero++ (pós): imprime ANTES de incrementar → " + numero++);
        System.out.println("agora numero é: " + numero);  // 6

        System.out.println("++numero (pré): incrementa ANTES de imprimir → " + (++numero));
        System.out.println("agora numero é: " + numero);  // 7

        numero--;
        System.out.println("numero-- → " + numero);      // 6

        boolean verdadeiro = true;
        System.out.println("\nboolean verdadeiro = " + verdadeiro);
        System.out.println("!verdadeiro = " + !verdadeiro);   // inverte

        // ========================
        // 5. TERNÁRIO
        // ========================
        System.out.println("\n=== Operador Ternário ===");
        // Sintaxe: <condição> ? <se true> : <se false>

        int nota = 7;
        String resultadoNota = (nota >= 7) ? "Aprovado" : "Reprovado";
        System.out.println("Nota " + nota + " → " + resultadoNota);

        // Ternário encadeado
        int nota2 = 5;
        String resultadoNota2 = nota2 >= 7 ? "Aprovado"
                              : nota2 >= 5 ? "Recuperação"
                              : "Reprovado";
        System.out.println("Nota " + nota2 + " → " + resultadoNota2);

        // Exemplo prático: verificar se número é par ou ímpar
        int num = 8;
        String paridade = (num % 2 == 0) ? "Par" : "Ímpar";
        System.out.println(num + " é " + paridade);

        // ========================
        // 6. LÓGICOS
        // ========================
        System.out.println("\n=== Operadores Lógicos ===");

        boolean condicao1 = true;
        boolean condicao2 = false;

        // && = E: ambas precisam ser true
        System.out.println("true  && false = " + (condicao1 && condicao2));
        System.out.println("true  && true  = " + (condicao1 && true));

        // || = OU: pelo menos uma precisa ser true
        System.out.println("true  || false = " + (condicao1 || condicao2));
        System.out.println("false || false = " + (condicao2 || false));

        // Exemplo prático
        int salario = 3000;
        boolean temExperiencia = true;

        if (salario >= 2000 && temExperiencia) {
            System.out.println("\nCandidato aprovado! (salário OK e tem experiência)");
        }

        int idadeCliente = 17;
        boolean temAutorizacao = true;

        if (idadeCliente >= 18 || temAutorizacao) {
            System.out.println("Acesso permitido!");
        }
    }
}
