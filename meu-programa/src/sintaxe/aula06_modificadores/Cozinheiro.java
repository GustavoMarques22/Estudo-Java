package sintaxe.aula06_modificadores;

/**
 * Aula 06 - Modificadores de Acesso
 *
 * Conceitos:
 * - public:    visível para qualquer classe em qualquer pacote
 * - private:   visível apenas dentro da própria classe
 * - protected: visível no mesmo pacote e em subclasses (herança)
 * - default:   visível apenas no mesmo pacote (sem palavra reservada)
 *
 * Contexto: simulação de uma lanchonete
 */
public class Cozinheiro {

    // PUBLIC — qualquer classe pode chamar
    public void adicionarLancheNoBalcao() {
        System.out.println("[Balcão] Lanche adicionado!");
        prepararLanche();   // chama método privado internamente
    }

    public void adicionarSucoNoBalcao() {
        System.out.println("[Balcão] Suco adicionado!");
        prepararVitamina(); // chama método privado internamente
    }

    public void adicionarComboNoBalcao() {
        System.out.println("[Balcão] Combo lanche + suco adicionado!");
        prepararLanche();
        prepararVitamina();
    }

    // PRIVATE — só o próprio cozinheiro conhece esses passos internos
    private void lavarIngredientes() {
        System.out.println("[Cozinha] Lavando ingredientes...");
    }

    private void selecionarIngredientes() {
        System.out.println("[Cozinha] Selecionando ingredientes...");
    }

    private void prepararLanche() {
        lavarIngredientes();
        selecionarIngredientes();
        System.out.println("[Cozinha] Lanche preparado!");
    }

    private void prepararVitamina() {
        lavarIngredientes();
        System.out.println("[Cozinha] Vitamina preparada!");
    }

    // DEFAULT (sem modificador) — visível apenas no mesmo pacote
    void pedirParaTrocarGas() {
        System.out.println("[Cozinha] Precisamos trocar o gás!");
    }
}
