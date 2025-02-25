package example.model;

/**
 * This class represent a particular instance of a BankAccount.
 * In particular, a Simple Bank Account allows always the deposit
 * while the withdrawal is allowed only if the balance greater or equal the withdrawal amount
 */
public final class SimpleBankAccount implements BankAccount {

    private final AccountHolder holder;
    private double balance;
    private final double fee;

    public SimpleBankAccount(final AccountHolder holder, final double balance, final double fee) {
        this.holder = holder;
        this.balance = balance;
        this.fee = fee;
    }

    @Override
    public AccountHolder getHolder() {
        return this.holder;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public double getFee() {
        return this.fee;
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID) && checkAmount(amount)) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (isWithdrawAllowed(userID, amount)) {
            this.balance -= (amount + this.fee);
        }
    }

    private boolean isWithdrawAllowed(final int userID, final double amount) {
        return checkUser(userID) && checkAmount(amount) && (this.balance - this.fee >= amount);
    }

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }

    private boolean checkAmount(final double amount) {
        return amount > 0;
    }
}
