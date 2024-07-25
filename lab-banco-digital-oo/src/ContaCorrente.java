public class ContaCorrente extends Conta {

    private double limiteCredito;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.limiteCredito = 0;
    }

    @Override
    public void alterarLimiteDeCredito(double novoLimite) {
        this.limiteCredito = novoLimite;
        System.out.println("Novo limite de crédito: " + novoLimite);
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Notificação para Conta Corrente: " + mensagem);
    }

}
