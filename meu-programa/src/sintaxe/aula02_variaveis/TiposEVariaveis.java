package sintaxe.aula02_variaveis;

/**
 * Aula 02 - Tipos Primitivos e Variáveis
 *
 * Conceitos:
 * - Tipos primitivos: byte, short, int, long, float, double, boolean, char
 * - Tipos Wrapper: Integer, Double, Boolean, etc.
 * - Constantes: final + CAIXA_ALTA
 * - Conversão de tipos (casting)
 * - Regras de nomenclatura (camelCase para variáveis)
 */
public class TiposEVariaveis {

    public static void main(String[] args) {

        // ========================
        // 1. TIPOS PRIMITIVOS
        // ========================
        System.out.println("=== Tipos Primitivos ===");

        byte idade = 25;                        // -128 a 127
        short ano = 2024;                       // -32.768 a 32.767
        int cep = 75110210;                     // tipo mais comum para inteiros
        long cpf = 12345678901L;                // precisa do L no final
        float altura = 1.75F;                   // precisa do F no final
        double salario = 4500.50;               // mais preciso que float
        boolean estaAtivo = true;               // true ou false
        char inicial = 'J';                     // um único caractere, com aspas simples

        System.out.println("byte   - idade:   " + idade);
        System.out.println("short  - ano:     " + ano);
        System.out.println("int    - cep:     " + cep);
        System.out.println("long   - cpf:     " + cpf);
        System.out.println("float  - altura:  " + altura);
        System.out.println("double - salario: " + salario);
        System.out.println("boolean - ativo:  " + estaAtivo);
        System.out.println("char   - inicial: " + inicial);

        // ========================
        // 2. VALORES PADRÃO
        // ========================
        System.out.println("\n=== Valores Padrão (sem atribuição) ===");
        // Tipos primitivos sempre têm valor padrão quando são atributos de classe
        // int = 0, double = 0.0, boolean = false, char = '\u0000'
        System.out.println("int padrão:     0");
        System.out.println("double padrão:  0.0");
        System.out.println("boolean padrão: false");

        // ========================
        // 3. CONSTANTES
        // ========================
        System.out.println("\n=== Constantes ===");

        final double VALOR_PI = 3.14159;
        final int ESTADOS_BRASILEIROS = 27;
        final String MOEDA_PADRAO = "BRL";

        System.out.println("PI:                 " + VALOR_PI);
        System.out.println("Estados:            " + ESTADOS_BRASILEIROS);
        System.out.println("Moeda:              " + MOEDA_PADRAO);
        // VALOR_PI = 3.15; // ERRO! constante não pode ser alterada

        // ========================
        // 4. TIPOS WRAPPER
        // ========================
        System.out.println("\n=== Tipos Wrapper ===");

        Integer numeroInteiro = 100;
        Double numeroDecimal = 9.99;
        Boolean ativo = Boolean.TRUE;
        Character letra = 'A';

        System.out.println("Integer:   " + numeroInteiro);
        System.out.println("Double:    " + numeroDecimal);
        System.out.println("Boolean:   " + ativo);
        System.out.println("Character: " + letra);

        // Conversão String -> número (muito usado em projetos reais)
        String numeroTexto = "42";
        int numeroConvertido = Integer.parseInt(numeroTexto);
        double decimalConvertido = Double.parseDouble("3.14");

        System.out.println("\nString '42' convertida para int: " + numeroConvertido);
        System.out.println("String '3.14' convertida para double: " + decimalConvertido);

        // Limites dos tipos
        System.out.println("\nMáximo int:    " + Integer.MAX_VALUE);
        System.out.println("Mínimo int:    " + Integer.MIN_VALUE);
        System.out.println("Máximo double: " + Double.MAX_VALUE);

        // ========================
        // 5. CONVERSÃO DE TIPOS (CASTING)
        // ========================
        System.out.println("\n=== Conversão de Tipos ===");

        // Implícita: de menor para maior (sem perda)
        int inteiro = 100;
        double doubleDeCima = inteiro;   // int -> double sem cast
        System.out.println("int para double (implícito): " + doubleDeCima);

        // Explícita: de maior para menor (pode perder dados)
        double decimal = 9.99;
        int inteiroCortado = (int) decimal; // perde a parte decimal
        System.out.println("double 9.99 para int (explícito): " + inteiroCortado);
    }
}
