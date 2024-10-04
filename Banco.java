package lista3;

import javax.swing.JOptionPane;

public class Banco {
    public static void main(String[] args) throws NumberFormatException{
        String nome = typeString("Digite o nome do cliente");
        String cpf = typeString("Digente o cpf do cliente");
        double saldo;
        try {
            saldo = typeDouble("Digite o saldo do cliente");
        }catch (NumberFormatException NumberF){
            saldo = typeDouble("Valor inválido! Tente novamente");
        }


        Conta c = new Conta(saldo, nome, cpf);
        double deposito = typeDouble ("Digite o valor do saque");
        c.deposita(deposito);

        double saque = typeDouble("DIgite o valor do saque");
        try {
            c.saca(saque);

        }
        catch (SaldoInsuficienteException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage()+
                    "\nOperação não realizada!");
        }
        JOptionPane.showMessageDialog(null, c.toString());

    }
    private static double typeDouble(String txt){
        String userInput = JOptionPane.showInputDialog(txt);
        double d = Double.parseDouble(userInput);
        return d;
    }
    private static String typeString(String txt){
        return JOptionPane.showInputDialog(null, txt);
    }

}
