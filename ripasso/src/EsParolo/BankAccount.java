package EsParolo;

public class BankAccount {
    Integer balance;

    public BankAccount(Integer account) {
        this.balance = account;
    }

    void withdraw(int amount) {
        balance -= amount;
    }

    void deposit(int amount) {
        balance += amount;
    }

    public Integer getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        int reps = 1;
        int nThreads = 3;
        Integer balance = 1000;
        BankAccount account = new BankAccount(balance);

        Thread[] threads = new Thread[nThreads];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < reps; j++) {
                    if (account.getBalance() >= 400) account.withdraw(400);
                    try {
                        Thread.sleep((int)(Math.random() * 1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }


        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Valore effettivo: " + account.balance);
    }
}
