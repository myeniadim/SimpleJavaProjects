public class Customer extends Person{
    private double balance;
    private double prevTrans;

    public Customer(String name, String surname, int accountId, String password, double balance, double prevTrans) {
        super(name, surname, accountId, password);
        this.balance = balance;
        this.prevTrans = prevTrans;
    }

    public double getBalance() {
        return balance;
    }

    public double getPrevTrans() {
        return prevTrans;
    }

    public void deposit(double amount){
        if (amount > 0) {
            this.balance += amount;
            this.prevTrans = amount;
            System.out.println("Money is deposited: " + amount);
        }else {
            System.out.println("The amount is cannot be negative or 0!");
        }
    }

    public void withdraw(double amount){
        if (amount > 0 && balance>= amount){
            this.balance-=amount;
            this.prevTrans=-amount;
            System.out.println("Money is withdrawn: " + amount);
        } else if (balance < amount) {
            System.out.println("Balance is insufficient!");
        }
    }
}
