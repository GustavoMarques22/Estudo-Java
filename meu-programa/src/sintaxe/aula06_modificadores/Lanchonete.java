package sintaxe.aula06_modificadores;

/**
 * Demonstra modificadores de acesso na prática.
 * O estabelecimento só enxerga os métodos públicos do Cozinheiro.
 */
public class Lanchonete {

    public static void main(String[] args) {

        System.out.println("=== Modificadores de Acesso ===\n");

        Cozinheiro cozinheiro = new Cozinheiro();

        // Só conseguimos chamar os métodos PUBLIC do Cozinheiro
        // Os métodos private (prepararLanche, lavarIngredientes, etc.)
        // são invisíveis daqui — encapsulamento em ação!

        System.out.println("--- Pedido chegou ---");
        cozinheiro.adicionarLancheNoBalcao();

        System.out.println("\n--- Outro pedido ---");
        cozinheiro.adicionarSucoNoBalcao();

        System.out.println("\n--- Pedido combo ---");
        cozinheiro.adicionarComboNoBalcao();

        // Método default: acessível pois estamos no mesmo pacote
        System.out.println();
        cozinheiro.pedirParaTrocarGas();

        // cozinheiro.prepararLanche();   // ERRO! private — não acessível aqui
        // cozinheiro.lavarIngredientes();// ERRO! private — não acessível aqui
    }
}
