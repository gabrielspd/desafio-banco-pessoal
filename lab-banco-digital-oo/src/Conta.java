import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> historicoTransacoes;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.historicoTransacoes = new ArrayList<>();
    }

    public int getNumeroConta() {
        return numero;
    }


    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
			registrarTransacao(new Transacao("Saque", valor));
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public void imprimirExtrato() {
        imprimirInfosComuns(); 
        System.out.println("=== Extrato ===");
        for (Transacao transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
			registrarTransacao(new Transacao("Depósito", valor));
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor > 0 && valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            registrarTransacao(new Transacao("Transferência", valor));
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

	@Override
    public void fecharConta() {
        if (saldo == 0) {
            System.out.println("Conta fechada com sucesso.");
        } else {
            System.out.println("Não é possível fechar a conta com saldo pendente.");
        }
    }

	@Override
    public List<Transacao> obterHistoricoTransacoes() {
        return historicoTransacoes;
    }

    @Override
    public void emitirExtratoDetalhado() {
        System.out.println("Extrato detalhado:");
        imprimirInfosComuns();
        System.out.println("Histórico de Transações:");
        for (Transacao transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Notificação: " + mensagem);
    }

    @Override
    public void aplicarJuros(double taxaDeJuros) {
        System.out.println("Método não suportado para esta conta.");
    }

	@Override
    public void alterarLimiteDeCredito(double novoLimite) {
        System.out.println("Método não suportado para esta conta.");
    }
	
    @Override
    public boolean validarTransacao(double valor) {
        return valor > 0;
    }

	protected void registrarTransacao(Transacao transacao) {
        historicoTransacoes.add(transacao);
    }

    protected void imprimirInfosComuns() {
        System.out.println("=== Dados da Conta ===");
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
