package EsParolo;

public class Storage {
    int quantity = 10;

    void produce() {
        quantity++;
    }

    synchronized boolean consume() {
        if (quantity > 0) {
            quantity--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        int nThread = 10;
        int interactions = 10;
        Thread[] threads = new Thread[nThread];
        Storage s = new Storage();
        for (int i = 0; i < nThread; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < interactions; j++) {
                    if (Math.round(Math.random() * 10) % 2 == 0) {
                        s.produce();
                    } else {
                        if (s.consume()) {
                            //System.out.println("consumed");
                        } else {
                            System.out.println("not consumed empty");
                        }
                    }
                }
            });
        }

        for (int i = 0; i < nThread; i++) {
            threads[i].start();
        }

        for (int i = 0; i < nThread; i++) {
            threads[i].join();
        }
        System.out.println(s.quantity);
    }
}
