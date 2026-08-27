package sintaxe.aula04_comentarios;

/**
 * Aula 04 - Comentários e Javadoc
 *
 * Calculadora Simples — exemplo de documentação com Javadoc.
 *
 * Conceitos:
 * - Comentário de linha única: //
 * - Comentário de múltiplas linhas: /* * /
 * - Javadoc: /** * / com tags @param, @return, @author, etc.
 *
 * @author Rocketseat
 * @version 1.0
 */
public class Calculadora {

    /**
     * Soma dois números inteiros.
     *
     * @param n1 primeiro número
     * @param n2 segundo número
     * @return resultado da soma
     */
    public static int somar(int n1, int n2) {
        return n1 + n2;
    }

    /**
     * Subtrai o segundo número do primeiro.
     *
     * @param n1 número base
     * @param n2 número a subtrair
     * @return resultado da subtração
     */
    public static int subtrair(int n1, int n2) {
        return n1 - n2;
    }

    /**
     * Multiplica dois números.
     *
     * @param n1 primeiro fator
     * @param n2 segundo fator
     * @return produto da multiplicação
     */
    public static int multiplicar(int n1, int n2) {
        return n1 * n2;
    }

    /**
     * Divide o dividendo pelo divisor.
     *
     * @param dividendo número a ser dividido
     * @param divisor   número que divide
     * @return resultado da divisão
     * @throws ArithmeticException se o divisor for zero
     */
    public static double dividir(int dividendo, int divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        return (double) dividendo / divisor;
    }

    public static void main(String[] args) {

        // Comentário de linha única: usado para explicar uma linha específica

        /*
         * Comentário de múltiplas linhas:
         * usado para blocos maiores de explicação
         * ou para desativar temporariamente um trecho de código
         */

        System.out.println("=== Calculadora ===");

        // Testando cada operação
        System.out.println("10 + 5  = " + somar(10, 5));
        System.out.println("10 - 5  = " + subtrair(10, 5));
        System.out.println("10 * 5  = " + multiplicar(10, 5));
        System.out.println("10 / 3  = " + dividir(10, 3));

        // Testando exceção com divisão por zero
        try {
            System.out.println("10 / 0  = " + dividir(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
