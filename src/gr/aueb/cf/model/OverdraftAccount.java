package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;

public class OverdraftAccount extends Account {

    public OverdraftAccount() {}

    public OverdraftAccount(User holder, String iban, double balance) {
        super(holder, iban, balance);
    }

    /**
     * Withdraws a greater amount of money than balance.
     * @param amount
     *              the amount of money.
     * @param ssn
     *              the ssn of user.
     * @throws SsnNotValidException
     *              if ssn is not valid.
     * @throws NegativeAmountException
     *               if amount is negative.
     */
    @Override
    public void withdraw(double amount, String ssn)
            throws  SsnNotValidException, NegativeAmountException {

        try {
            if (amount < 0) throw new NegativeAmountException(amount);
            if (!isSsnValid(ssn)) throw new SsnNotValidException(ssn);

            setBalance(getBalance() - amount);
        } catch (SsnNotValidException | NegativeAmountException e) {
            System.err.println("Error: withdrawal");
            throw e;
        }
    }
}
