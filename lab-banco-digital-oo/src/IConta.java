import java.util.List;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, IConta contaDestino);

    void imprimirExtrato();

    double consultarSaldo();

    List<Transacao> obterHistoricoTransacoes();

    void alterarLimiteDeCredito(double novoLimite);

    void fecharConta();

    void emitirExtratoDetalhado();

    void enviarNotificacao(String mensagem);

    void aplicarJuros(double taxaDeJuros);

    boolean validarTransacao(double valor);
}
