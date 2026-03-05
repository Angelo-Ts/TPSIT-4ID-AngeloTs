public class Magazzino {
    private int quantita;

    public Magazzino(int quantitaIniziale) {
        this.quantita = quantitaIniziale;
    }

    // Versione SENZA sincronizzazione - per evidenziare la race condition
    public void depositaSenzaSync(int quantita) {
        // Simuliamo un piccolo ritardo per aumentare la probabilità di race condition
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.quantita += quantita;
        System.out.println(Thread.currentThread().getName() + " ha depositato " + quantita + ". Quantità totale: " + this.quantita);
    }

    public boolean relevaSenzaSync(int quantita) {
        if (this.quantita >= quantita) {
            // Simuliamo un piccolo ritardo per aumentare la probabilità di race condition
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.quantita -= quantita;
            System.out.println(Thread.currentThread().getName() + " ha prelevato " + quantita + ". Quantità totale: " + this.quantita);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " Non può prelevare " + quantita + ". Quantità insufficiente: " + this.quantita);
            return false;
        }
    }

    // Versione CON sincronizzazione - thread-safe
    public synchronized void deposita(int quantita) {
        this.quantita += quantita;
        System.out.println(Thread.currentThread().getName() + " ha depositato " + quantita + ". Quantità totale: " + this.quantita);
    }

    public synchronized boolean releva(int quantita) {
        if (this.quantita >= quantita) {
            this.quantita -= quantita;
            System.out.println(Thread.currentThread().getName() + " ha prelevato " + quantita + ". Quantità totale: " + this.quantita);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " Non può prelevare " + quantita + ". Quantità insufficiente: " + this.quantita);
            return false;
        }
    }

    public synchronized int getQuantita() {
        return quantita;
    }
}

