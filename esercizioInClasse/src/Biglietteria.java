public class Biglietteria {
    private int postiDisponibili;

    public Biglietteria(int postiIniziali) {
        this.postiDisponibili = postiIniziali;
    }

    // Versione SENZA sincronizzazione - per evidenziare la race condition
    public boolean acquistaSenzaSync() {
        if (postiDisponibili > 0) {
            // Simuliamo un piccolo ritardo per aumentare la probabilità di race condition
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            postiDisponibili--;
            System.out.println(Thread.currentThread().getName() + " ha acquistato un biglietto. Posti rimasti: " + postiDisponibili);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " Non ci sono posti disponibili");
            return false;
        }
    }

    // Versione CON sincronizzazione - thread-safe
    public synchronized boolean acquista() {
        if (postiDisponibili > 0) {
            postiDisponibili--;
            System.out.println(Thread.currentThread().getName() + " ha acquistato un biglietto. Posti rimasti: " + postiDisponibili);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " Non ci sono posti disponibili");
            return false;
        }
    }

    public synchronized int getPostiDisponibili() {
        return postiDisponibili;
    }
}

