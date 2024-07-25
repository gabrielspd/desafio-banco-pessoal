public class Transacao {

    private String tipo; 
    private double valor;

    public Transacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.format("Tipo: %s, Valor: %.2f", tipo, valor);
    }
}
