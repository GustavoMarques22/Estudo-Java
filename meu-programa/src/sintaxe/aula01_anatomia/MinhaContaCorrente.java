package sintaxe.aula01_anatomia;

/**
 * Aula 01 - Anatomia de Classes
 *
 * Conceitos:
 * - Toda classe começa com letra MAIÚSCULA
 * - O arquivo .java deve ter o mesmo nome da classe pública
 * - O método main é o ponto de entrada do programa
 * - Atributos representam características do objeto
 * - Métodos representam comportamentos do objeto
 */
public class MinhaContaCorrente {

    // Atributos (características)
    int numero;
    String titular;
    double saldo;

    // Método sacar: recebe um valor e subtrai do saldo
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente! Saldo atual: R$ " + saldo);
        } else {
            saldo = saldo - valor;
            System.out.println("Saque de R$" + valor + " realizado.");
            System.out.println("Saldo atual: R$" + saldo);
        }
    }

    // Método depositar
    public void depositar(double valor) {
        saldo = saldo + valor;
        System.out.println("Depósito de R$" + valor + " realizado.");
        System.out.println("Saldo atual: R$" + saldo);
    }

    public static void main(String[] args) {

        // Criando um objeto (instância) da classe MinhaContaCorrente
        MinhaContaCorrente conta = new MinhaContaCorrente();

        // Definindo os atributos
        conta.numero = 1001;
        conta.titular = "João Silva";
        conta.saldo = 1500.00;

        // Imprimindo dados da conta
        System.out.println("=== Conta Corrente ===");
        System.out.println("Número: " + conta.numero);
        System.out.println("Titular: " + conta.titular);
        System.out.println("Saldo: R$ " + conta.saldo);
        System.out.println("---------------------");

        // Testando os métodos
        conta.sacar(200.00);
        System.out.println("---------------------");
        conta.depositar(500.00);
        System.out.println("---------------------");
        conta.sacar(2000.00); // tentativa com saldo insuficiente
    }
}
