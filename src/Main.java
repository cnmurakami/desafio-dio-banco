public class Main {
    public static void main(String[] args) {
        Cliente caio = new Cliente();
        caio.setNome("Caio");
        Conta cc = new ContaCorrente(caio);
        Conta poupanca = new ContaPoupanca(caio);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
