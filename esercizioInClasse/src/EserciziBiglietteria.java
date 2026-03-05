public class EserciziBiglietteria {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== ESERCIZIO 3: BIGLIETTERIA POSTI LIMITATI ===\n");

        // PARTE 1: Evidenziare la RACE CONDITION (senza synchronized)
        System.out.println("--- PARTE 1: SENZA SINCRONIZZAZIONE (Race Condition) ---");
        Biglietteria biglietteriaSenzaSync = new Biglietteria(5);
        Thread[] threadSenzaSync = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threadSenzaSync[i] = new Thread(() -> {
                biglietteriaSenzaSync.acquistaSenzaSync();
            }, "Client-" + (i + 1));
        }

        for (int i = 0; i < 10; i++) {
            threadSenzaSync[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threadSenzaSync[i].join();
        }

        System.out.println("Posti rimasti (dovrebbero essere 0): " + biglietteriaSenzaSync.getPostiDisponibili());
        System.out.println("ATTENZIONE: Se i posti rimasti sono negativi, c'è stata una race condition!\n");

        // PARTE 2: Risolvere CON sincronizzazione
        System.out.println("--- PARTE 2: CON SINCRONIZZAZIONE (Thread-Safe) ---");
        Biglietteria bigliatteriaConSync = new Biglietteria(5);
        Thread[] threadConSync = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threadConSync[i] = new Thread(() -> {
                bigliatteriaConSync.acquista();
            }, "Client-" + (i + 1));
        }

        for (int i = 0; i < 10; i++) {
            threadConSync[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threadConSync[i].join();
        }

        System.out.println("Posti rimasti (dovrebbero essere 0): " + bigliatteriaConSync.getPostiDisponibili());
        System.out.println("✅ CORRETTO: Non ci sono posti negativi!");
    }
}

