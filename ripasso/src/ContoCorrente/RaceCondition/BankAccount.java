package ContoCorrente.RaceCondition;

public class BankAccount {
    private int balance;  // Il deposito

    public BankAccount(int initBalance) {
        this.balance = initBalance;
    }  // Si crea il conto con il saldo iniziale

    public int getBalance() { return this.balance; }  // Si ottiene il saldo iniziale

    public void setBalance(int newBalance) { this.balance = newBalance; }  // Si salva il nuovo saldo a seguito di un'operazione
}
