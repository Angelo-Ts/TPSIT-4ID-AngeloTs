public class CallMioThread {
    public static void main(String[] args) {
        final String ROSSO = "\u001B[31m";
        final String BLU = "\u001B[34m";
        final String BIANCO = "\u001B[37m";

        System.out.println(BIANCO + "=== Esempio 1: Estendere Thread === \n");
         
        
        Miothread t1 = new Miothread(ROSSO + "Thread-1");
        Miothread t2 = new Miothread(BLU + "Thread-2");
        Miothread t3 = new Miothread(BIANCO + "Thread-3");

        try {
            System.out.println(BIANCO + "Avvio dei Thread \n");
            t1.start(); //Avvia il primo thread tramite dispatcher OS
            t2.start(); //Avvia il secondo thread tramite dispatcher OS
            t3.start();
            
            //Attende la terminazione dei thread altrimenti
            //il main protrebbe terminare prima che i thread t1 e t2 finiscano il loro lavoro
            t1.join(); //
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\033[31m === Fine Esempio ===");
    }
}
