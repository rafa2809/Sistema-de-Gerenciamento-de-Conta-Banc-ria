package lista3;

public class Conta {
    private double saldo;
    private String nome, cpf;
    private final double limite = 200.0;

    public Conta(double saldo, String nome, String cpf) {
        this.setSaldo(saldo);
        this.setNome(nome);
        this.setCpf(cpf);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = (saldo < 0) ? 0 : saldo;
    }
    public void deposita(double valor) {
        setSaldo((valor < 0) ? saldo : saldo + valor);
    }
    public void saca(double valor) throws SaldoInsuficienteException {
        try {
            if (valor > (getSaldo() + limite)) {
                throw new SaldoInsuficienteException("Saque acima do limite disponível.");
            } else if (valor > getSaldo()) {
                double limiteUtilizado = valor - getSaldo();
                setSaldo(0.0);
                System.out.println("Saque realizado. Limite utilizado: R$ " + limiteUtilizado);
            } else {
                setSaldo(getSaldo() - valor);
                System.out.println("Saque realizado. Novo saldo: R$ " + getSaldo());
            }
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public String toString() {
        return "Cliente: " + this.nome +
                "\nCPF: " + this.cpf + "\nSaldo " + this.saldo;
    }
}