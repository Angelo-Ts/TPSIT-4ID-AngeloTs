package EsParolo;

public class Counter {

    int val = 0;

     synchronized void increment() {
        val++;
    }

    void decrement() {
        val++;
    }

    int getVal() {
        return val;
    }

    public static void main(String[] args) {
        int reps = 1_000;
        int nThreads = 1_000;
        Counter c = new Counter();

        Thread[] threads = new Thread[nThreads];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < reps; j++) {
                    c.increment();
                    try {
                        Thread.sleep((int)(10 * Math.random()));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    //System.out.print("");
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
        System.out.println("Valore aspettato: " + reps*nThreads + " Valore effettivo: " + c.getVal());
    }
}
