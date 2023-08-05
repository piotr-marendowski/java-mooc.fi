class Account {

    private double balance;
    private String owner;

    public Account(String owner, double balance) {
        this.balance = balance;
        this.owner = owner;
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    public void withdrawal(double amount) {
        this.balance = this.balance - amount;
    }

    public double saldo() {
        return this.balance;
    }

    @Override
    public String toString() {
        return this.owner + " balance: " + this.balance;
    }
}

public class YourFirstAccount {
    public static void main(String[] args) {

        Account testAccount = new Account("test", 100.00);

        System.out.println(testAccount);

        testAccount.deposit(20.0);
        System.out.println(testAccount);
    }
}
