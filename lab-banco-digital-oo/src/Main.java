public class Main {

    public static void main(String[] args) {
        // Criar clientes
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Venilton");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Gabriel");

        // Criar contas
        Conta cc = new ContaCorrente(cliente1);
        Conta poupanca = new ContaPoupanca(cliente2);

        // Testar operações na ContaCorrente
        System.out.println("** Teste Conta Corrente **");
        cc.depositar(500);
        cc.sacar(100);
        cc.transferir(200, poupanca);
        cc.imprimirExtrato();
        cc.emitirExtratoDetalhado();

        // Testar operações na ContaPoupanca
        System.out.println("\n** Teste Conta Poupança **");
        poupanca.aplicarJuros(5);  // Aplicar 5% de juros
        poupanca.imprimirExtrato();
        poupanca.emitirExtratoDetalhado();
    }
}
