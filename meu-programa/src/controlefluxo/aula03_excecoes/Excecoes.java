package controlefluxo.aula03_excecoes;

import java.util.Locale;
import java.util.Scanner;

/**
 * Controle de Fluxo — Aula 03: Exceções
 *
 * Conceitos:
 * - try / catch / finally
 * - Exceções comuns (NullPointerException, ArithmeticException, etc.)
 * - Exceções customizadas (extends Exception)
 * - throw e throws
 * - Checked vs Unchecked exceptions
 */
public class Excecoes {

    public static void main(String[] args) {

        // ========================
        // 1. EXCEÇÕES COMUNS
        // ========================
        System.out.println("=== Exceções Comuns ===");

        // ArithmeticException: divisão por zero
        System.out.println("\n-- ArithmeticException (divisão por zero) --");
        try {
            int resultado = 10 / 0;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Capturada! " + e.getMessage());
        }

        // NullPointerException: usar variável nula
        System.out.println("\n-- NullPointerException --");
        try {
            String texto = null;
            System.out.println(texto.length()); // explode aqui
        } catch (NullPointerException e) {
            System.out.println("Capturada! Tentou usar uma variável nula.");
        }

        // NumberFormatException: converter texto inválido em número
        System.out.println("\n-- NumberFormatException --");
        try {
            int numero = Integer.parseInt("abc123");
        } catch (NumberFormatException e) {
            System.out.println("Capturada! " + e.getMessage());
        }

        // ArrayIndexOutOfBoundsException: acessar índice inexistente
        System.out.println("\n-- ArrayIndexOutOfBoundsException --");
        try {
            int[] numeros = {1, 2, 3};
            System.out.println(numeros[5]); // índice 5 não existe
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Capturada! Índice fora dos limites.");
        }

        // ========================
        // 2. TRY / CATCH / FINALLY
        // ========================
        System.out.println("\n=== Try / Catch / Finally ===");

        try {
            System.out.println("Tentando executar...");
            int[] array = new int[3];
            array[10] = 5; // vai lançar exceção
            System.out.println("Esta linha não será executada.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        } finally {
            // Sempre executado, com ou sem exceção
            System.out.println("Finally: executado SEMPRE (ex: fechar conexão)");
        }

        // ========================
        // 3. MÚLTIPLOS CATCH
        // ========================
        System.out.println("\n=== Múltiplos Catch ===");

        String[] valores = {"10", null, "abc", "0"};

        for (String valor : valores) {
            try {
                int numero = Integer.parseInt(valor);
                int resultado = 100 / numero;
                System.out.println("100 / " + valor + " = " + resultado);
            } catch (NullPointerException e) {
                System.out.println("Valor nulo encontrado!");
            } catch (NumberFormatException e) {
                System.out.println("'" + valor + "' não é um número válido!");
            } catch (ArithmeticException e) {
                System.out.println("Divisão por zero com valor " + valor + "!");
            }
        }

        // ========================
        // 4. EXCEÇÃO CUSTOMIZADA
        // ========================
        System.out.println("\n=== Exceção Customizada (CepInvalidoException) ===");

        String[] ceps = {"12345678", "123", "87654321"};

        for (String cep : ceps) {
            try {
                String cepFormatado = formatarCep(cep);
                System.out.println("CEP " + cep + " formatado: " + cepFormatado);
            } catch (CepInvalidoException e) {
                System.out.println("Erro no CEP '" + cep + "': " + e.getMessage());
            }
        }

        // ========================
        // 5. ABOUT ME (exemplo do PDF com Scanner)
        // ========================
        // Descomente o bloco abaixo para testar interativamente:
        /*
        System.out.println("\n=== AboutMe (Scanner) ===");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        try {
            System.out.print("Nome: ");
            String nome = scanner.next();
            System.out.print("Sobrenome: ");
            String sobrenome = scanner.next();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            System.out.print("Altura: ");
            double altura = scanner.nextDouble();

            System.out.println("Olá, " + nome.toUpperCase() + " " + sobrenome.toUpperCase()
                + "! Você tem " + idade + " anos e mede " + altura + "m.");
        } catch (Exception e) {
            System.out.println("Entrada inválida: " + e.getClass().getSimpleName());
        } finally {
            scanner.close();
        }
        */
    }

    // Método que declara que pode lançar uma exceção customizada (throws)
    static String formatarCep(String cep) throws CepInvalidoException {
        if (cep.length() != 8) {
            throw new CepInvalidoException("CEP deve ter exatamente 8 dígitos. Recebido: " + cep.length());
        }
        return cep.substring(0, 5) + "-" + cep.substring(5);
    }
}
