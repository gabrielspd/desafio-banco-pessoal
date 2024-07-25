import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public boolean removerConta(String numeroConta) {
        Optional<Conta> conta = contas.stream()
                                      .filter(c -> Integer.valueOf(c.getNumeroConta()).equals(numeroConta))
                                      .findFirst();
        if (conta.isPresent()) {
            contas.remove(conta.get());
            return true;
        }
        return false;
    }

    public Conta buscarConta(String numeroConta) {
        return contas.stream()
                     .filter(c -> Integer.valueOf(c.getNumeroConta()).equals(numeroConta))
                     .findFirst()
                     .orElse(null);
    }

    public void listarContas() {
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }
}
