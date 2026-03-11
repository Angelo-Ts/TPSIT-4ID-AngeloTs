package ContoCorrente;
import ContoCorrente.RaceCondition.Operation;
import ContoCorrente.RaceCondition.BankAccount;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int number = 3;  // Modificare a piacere per avere più operazioni

        BankAccount account = new BankAccount(1000);  // Si crea il conto in banca
        Operation[] operations = new Operation[number];  // Si crea l'insieme di operazioni

        for (int i = 0; i < number; i++) {  // Per ognuna delle operazioni
            int m = new Random().ints(10,500)
                    .findFirst().getAsInt();  // L'importo è generato casualmente
            if (i % 2 == 0) { m = -m; }  // Se l'indice è pari, l'importo è un prelievo. Se è dispari è un accredito
            operations[i] = new Operation(account, m);  // Si crea l'operazione
        }
        System.out.println("Saldo iniziale: " + account.getBalance() + "€.");  // Si stampa il saldo iniziale.
        for (int i = 0; i < number; i++) {  // Tutte le operazioni vengono fatte partire
            operations[i].start();
        }
        for (int i = 0; i < number; i++) {  // Si attende che tutte le operazioni siano finite
            try {
                operations[i].join();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Saldo Finale: " + account.getBalance() + "€.");  // Si stampa il saldo finale
    }
}