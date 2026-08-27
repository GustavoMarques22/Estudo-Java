package controlefluxo.aula03_excecoes;

/**
 * Exceção customizada para CEP inválido.
 *
 * Extende Exception (checked) — quem chamar o método
 * que lança esta exceção É OBRIGADO a tratá-la com try/catch.
 */
public class CepInvalidoException extends Exception {

    public CepInvalidoException(String mensagem) {
        super(mensagem);
    }
}
