public abstract class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
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
    public void sacar(double valor) {
        if (saldo >= valor) saldo -= valor;
        else System.out.println("Saldo insuficiente para a transação");
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
        else System.out.println("Valor inválido para depósito");
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (saldo >= valor) {
            contaDestino.depositar(valor);
            this.sacar(valor);
        }
        else System.out.println("Saldo insuficiente para a transação");
    }
    protected void imprimirInfosComuns(){
        System.out.println(String.format(("Titular: %s"), cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
