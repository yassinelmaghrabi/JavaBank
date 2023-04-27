import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankGui extends JFrame{
    private JPanel mainpanel;
    private JButton Deposit;
    private JButton Withdraw;
    private JButton Exit;
    private JTextField DepositValue;
    private JTextField WithdrawValue;
    private JLabel Balance;

    public BankGui(Bank bank){
        setContentPane(mainpanel);
        setTitle("Bank by Yassin Elmaghrabi");
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setVisible(true);
        Balance.setText("Bank Balance: " + bank.getBank_balance());

        Deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(DepositValue.getText());
                bank.deposit(amount);
                Balance.setText("Bank Balance: " + bank.getBank_balance());
            }
        });
        Withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int amount = Integer.parseInt(WithdrawValue.getText());
                bank.withdraw(amount);
                Balance.setText("Bank Balance: " + bank.getBank_balance());
            }
        });
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
class Bank {
    int bank_balance=0;
    public Bank(int bank_balance){
        this.bank_balance=bank_balance;
    }
    public Bank(){

    }
    public int getBank_balance(){
        return bank_balance;
    }
    public void deposit(int amount){
        bank_balance+=amount;
    }
    public void withdraw(int amount) {
        bank_balance -= amount;
    }
}
public class Main {

    public static void main(String[] args) {
        Bank _bank = new Bank();
        new BankGui(_bank);
            }

        }

