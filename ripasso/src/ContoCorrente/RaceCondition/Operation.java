package ContoCorrente.RaceCondition;

public class Operation extends Thread {
    private BankAccount account;  // L'operazione agisce su un conto
    private int transaction;  // L'operazione coinvolge una certa somma di denaro

    public Operation(BankAccount account, int transaction) {  // Costruttore
        this.account = account;  // Si configura il conto
        this.transaction = transaction;  // Si configura la transazione
        System.out.println("Operazione richiesta: " + transaction + "€.");  // Si stampano informazioni
    }

    @Override
    public void run() {
        int current = this.account.getBalance();  // Si legge l'attuale saldo e lo si salva <-- QUI SI VERIFICA LA RACE CONDITION!!
        System.out.println("Saldo prima dell'operazione: " + current + "€.");  // Lo si stampa
        current += this.transaction;  // Si effettua l'operazione <-- IL VALORE LETTO E SALVATO IN current POTREBBE NON ESSERE AGGIORNATO
        if (current >= 0) {  // C'erano abbastanza soldi?
            this.account.setBalance(current);  // Se sì si salva il nuovo saldo
        } else {
            System.out.println("Non è possibile effettuare il prelievo: conto negativo");  // Se no si restituisce un errore
        }
        System.out.println("Saldo dopo l'operazione: " + this.account.getBalance() + "€.");  // Si stampa il nuovo saldo
    }
}
