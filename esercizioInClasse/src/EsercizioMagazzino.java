public class EsercizioMagazzino {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== ESERCIZIO 4: MAGAZZINO PRODOTTI ===\n");

        // PARTE 1: Evidenziare la RACE CONDITION (senza synchronized)
        System.out.println("--- PARTE 1: SENZA SINCRONIZZAZIONE (Race Condition) ---");
        System.out.println("Quantità iniziale: 10");
        System.out.println("10 thread produttori (+1), 10 thread consumatori (-1)\n");

        Magazzino magazzino1 = new Magazzino(10);
        Thread[] threadsProduttori1 = new Thread[10];
        Thread[] threadsConsumatori1 = new Thread[10];

        // Creiamo 10 thread produttori
        for (int i = 0; i < 10; i++) {
            threadsProduttori1[i] = new Thread(() -> {
                magazzino1.depositaSenzaSync(1);
            }, "Produttore-" + (i + 1));
        }

        // Creiamo 10 thread consumatori
        for (int i = 0; i < 10; i++) {
            threadsConsumatori1[i] = new Thread(() -> {
                magazzino1.relevaSenzaSync(1);
            }, "Consumatore-" + (i + 1));
        }

        // Avviamo tutti i thread
        for (int i = 0; i < 10; i++) {
            threadsProduttori1[i].start();
            threadsConsumatori1[i].start();
        }

        // Attendiamo che tutti finiscano
        for (int i = 0; i < 10; i++) {
            threadsProduttori1[i].join();
            threadsConsumatori1[i].join();
        }

        System.out.println("Quantità finale (dovrebbe essere 10): " + magazzino1.getQuantita());
        if (magazzino1.getQuantita() < 0) {
            System.out.println("⚠️ CRITICO: La quantità è negativa! C'è stata una race condition!");
        } else if (magazzino1.getQuantita() != 10) {
            System.out.println("⚠️ ERRORE: La quantità non è corretta (dovrebbe essere 10). Race condition!");
        }

        System.out.println("\n--- PARTE 2: CON SINCRONIZZAZIONE (Thread-Safe) ---");
        System.out.println("Quantità iniziale: 10");
        System.out.println("10 thread produttori (+1), 10 thread consumatori (-1)\n");

        Magazzino magazzino2 = new Magazzino(10);
        Thread[] threadsProduttori2 = new Thread[10];
        Thread[] threadsConsumatori2 = new Thread[10];

        // Creiamo 10 thread produttori
        for (int i = 0; i < 10; i++) {
            threadsProduttori2[i] = new Thread(() -> {
                magazzino2.deposita(1);
            }, "Produttore-" + (i + 1));
        }

        // Creiamo 10 thread consumatori
        for (int i = 0; i < 10; i++) {
            threadsConsumatori2[i] = new Thread(() -> {
                magazzino2.releva(1);
            }, "Consumatore-" + (i + 1));
        }

        // Avviamo tutti i thread
        for (int i = 0; i < 10; i++) {
            threadsProduttori2[i].start();
            threadsConsumatori2[i].start();
        }

        // Attendiamo che tutti finiscano
        for (int i = 0; i < 10; i++) {
            threadsProduttori2[i].join();
            threadsConsumatori2[i].join();
        }

        System.out.println("Quantità finale (dovrebbe essere 10): " + magazzino2.getQuantita());
        if (magazzino2.getQuantita() == 10) {
            System.out.println("✅ CORRETTO: La quantità è rimasta invariata e non è mai negativa!");
        } else {
            System.out.println("⚠️ ERRORE: La quantità non è corretta!");
        }
    }
}

