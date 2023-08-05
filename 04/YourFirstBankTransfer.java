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

    public void withdraw(double amount) {
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

public class YourFirstBankTransfer {
    public static void main(String[] args) {

        Account MatthewsAccount = new Account("Matthews account", 100.00);
        Account MyAccount = new Account("My account", 0.00);

        MatthewsAccount.withdraw(100.00);
        MyAccount.deposit(100.00);

        System.out.println(MatthewsAccount);
        System.out.println(MyAccount);
    }
}
