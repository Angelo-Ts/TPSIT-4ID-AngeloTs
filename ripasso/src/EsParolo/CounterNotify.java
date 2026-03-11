package EsParolo;

public class CounterNotify {
    int val = 0;
    boolean free = true;

    void increment() {
        if (free) {
            free = false;
            val++;
            notifyAll();
            free = true;
        }
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        CounterNotify c = new CounterNotify();

        Thread[] threads = new Thread[nThreads];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < reps; j++) {

                    c.increment();

                    try {
                        Thread.sleep((int)(Math.random() * 10));
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
        System.out.println("Valore aspettato: " + reps*nThreads + " Valore effettivo: " + c.getVal());
    }
}
