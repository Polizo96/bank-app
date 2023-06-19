package gr.aueb.cf;

import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;
import gr.aueb.cf.model.Account;
import gr.aueb.cf.model.OverdraftAccount;
import gr.aueb.cf.model.OverdraftJointAccount;
import gr.aueb.cf.model.User;

public class Main {

    public static void main(String[] args) {
        User nikos = new User("Nikos","Pol","12345");
        User anna = new User("Anna","G.", "112233");
        Account account = new Account(nikos,"GR12345",100);
        Account overNikos = new OverdraftAccount(nikos, "GR23456", 50);
        Account overJointAccount = new OverdraftJointAccount(nikos, "GR232323", 200, anna);

        try {
            System.out.println("Account: \n" + account);
            System.out.println("Overdraft: \n" + overNikos);

            overJointAccount.deposit(100);
            overJointAccount.withdraw(50,"112233");

            System.out.println("Overdraft joint account: \n" + overJointAccount);

        } catch (NegativeAmountException | InsufficientBalanceException | SsnNotValidException e) {
            System.out.println(e.getMessage());
        }
    }
}
