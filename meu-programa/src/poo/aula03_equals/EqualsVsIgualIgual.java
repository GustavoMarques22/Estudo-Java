package poo.aula03_equals;

import java.util.Objects;

/**
 * POO — Aula 03: equals() vs ==
 *
 * Conceitos:
 * - == compara REFERÊNCIA (se apontam para o mesmo objeto na memória)
 * - equals() compara CONTEÚDO (se os valores dos atributos são iguais)
 * - Override de equals() e hashCode()
 * - Comparação de Strings, Integers e objetos customizados
 */

// ---- Carro SEM equals customizado ----
class CarroSimples {
    String cor;
    String marca;
    String modelo;

    CarroSimples(String cor, String marca, String modelo) {
        this.cor    = cor;
        this.marca  = marca;
        this.modelo = modelo;
    }
}

// ---- Carro COM equals e hashCode ----
class CarroComparado {
    String cor;
    String marca;
    String modelo;

    CarroComparado(String cor, String marca, String modelo) {
        this.cor    = cor;
        this.marca  = marca;
        this.modelo = modelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                         // mesma referência
        if (o == null || getClass() != o.getClass()) return false;
        CarroComparado outro = (CarroComparado) o;
        return Objects.equals(cor, outro.cor)
            && Objects.equals(marca, outro.marca)
            && Objects.equals(modelo, outro.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cor, marca, modelo);
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " " + cor;
    }
}

// ---- Classe Principal ----
public class EqualsVsIgualIgual {

    public static void main(String[] args) {

        // ========================
        // 1. STRING: == vs equals
        // ========================
        System.out.println("=== String: == vs equals ===");

        String nome1 = "JAVA";
        String nome2 = "JAVA";
        String nome3 = new String("JAVA"); // novo objeto na heap
        String nome4 = nome3;              // referência ao mesmo objeto que nome3

        System.out.println("nome1 = \"JAVA\"  (literal)");
        System.out.println("nome2 = \"JAVA\"  (literal)");
        System.out.println("nome3 = new String(\"JAVA\")  (novo objeto)");
        System.out.println("nome4 = nome3  (mesma referência)");

        System.out.println("\nnome1 == nome2   → " + (nome1 == nome2));   // true  (pool de strings)
        System.out.println("nome1 == nome3   → " + (nome1 == nome3));   // false (objetos diferentes)
        System.out.println("nome3 == nome4   → " + (nome3 == nome4));   // true  (mesma referência)

        System.out.println("\nnome1.equals(nome2) → " + nome1.equals(nome2)); // true
        System.out.println("nome2.equals(nome3) → " + nome2.equals(nome3)); // true
        System.out.println("nome3.equals(nome4) → " + nome3.equals(nome4)); // true

        // ========================
        // 2. INTEGER: == vs equals
        // ========================
        System.out.println("\n=== Integer: == vs equals ===");

        Integer num1 = 100;
        Integer num2 = 100;
        Integer num3 = 130;
        Integer num4 = 130;

        // Java faz cache de Integers de -128 a 127!
        System.out.println("num1=100, num2=100");
        System.out.println("num1 == num2     → " + (num1 == num2));     // true  (cache)
        System.out.println("num1.equals(num2)→ " + num1.equals(num2));  // true

        System.out.println("\nnum3=130, num4=130 (fora do cache -128..127)");
        System.out.println("num3 == num4     → " + (num3 == num4));     // false (objetos diferentes)
        System.out.println("num3.equals(num4)→ " + num3.equals(num4));  // true

        // ========================
        // 3. OBJETO SEM equals customizado
        // ========================
        System.out.println("\n=== Carro SEM equals customizado ===");

        CarroSimples c1 = new CarroSimples("branca", "Fiat", "Palio");
        CarroSimples c2 = new CarroSimples("branca", "Fiat", "Palio");

        System.out.println("c1 e c2 têm os mesmos dados, mas são objetos DIFERENTES");
        System.out.println("c1 == c2        → " + (c1 == c2));         // false
        System.out.println("c1.equals(c2)   → " + c1.equals(c2));      // false (sem override)

        // ========================
        // 4. OBJETO COM equals customizado
        // ========================
        System.out.println("\n=== Carro COM equals customizado ===");

        CarroComparado cc1 = new CarroComparado("branca", "Fiat", "Palio");
        CarroComparado cc2 = new CarroComparado("branca", "Fiat", "Palio");
        CarroComparado cc3 = new CarroComparado("preta",  "Fiat", "Palio");
        CarroComparado cc4 = cc1; // mesma referência

        System.out.println("cc1: " + cc1);
        System.out.println("cc2: " + cc2 + " (mesmos dados, objeto diferente)");
        System.out.println("cc3: " + cc3 + " (cor diferente)");
        System.out.println("cc4: referência de cc1");

        System.out.println("\ncc1 == cc2         → " + (cc1 == cc2));        // false
        System.out.println("cc1.equals(cc2)    → " + cc1.equals(cc2));      // true  (mesmo conteúdo)
        System.out.println("cc1.equals(cc3)    → " + cc1.equals(cc3));      // false (cor diferente)
        System.out.println("cc1 == cc4         → " + (cc1 == cc4));         // true  (mesma ref)
        System.out.println("cc1.equals(cc4)    → " + cc1.equals(cc4));      // true

        // ========================
        // CONCLUSÃO
        // ========================
        System.out.println("\n=== Conclusão ===");
        System.out.println("== compara se duas variáveis apontam para o MESMO objeto na memória.");
        System.out.println("equals() compara se o CONTEÚDO dos objetos é igual.");
        System.out.println("Para objetos customizados, SEMPRE sobrescreva equals() e hashCode().");
    }
}
