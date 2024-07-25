public class ContaPoupanca extends Conta {

    private static final double TAXA_JUROS = 0.08;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void aplicarJuros(double taxaDeJuros) {
        double juros = saldo * taxaDeJuros;
        saldo += juros;
        System.out.println("Juros aplicados: " + juros);
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public void emitirExtratoDetalhado() {
        System.out.println("Extrato detalhado da Conta Poupança:");
        imprimirInfosComuns();
        System.out.println("Saldo após aplicação de juros: " + saldo);
        System.out.println("Histórico de Transações:");
        for (Transacao transacao : obterHistoricoTransacoes()) {
            System.out.println(transacao);
        }
    }

}
