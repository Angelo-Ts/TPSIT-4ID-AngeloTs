package EsParolo;

public class TicketShop {
    int totTickets = 5;
    int leftTickets = 5;

    public TicketShop() {

    }

    synchronized public boolean buyTicket() {
        if (leftTickets > 0) {
            leftTickets--;
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws InterruptedException {
        int nThreads = 10;
        TicketShop tS = new TicketShop();
        Thread[] buyers = new Thread[nThreads];
        for (int i = 0; i < nThreads; i++) {
            buyers[i] = new Thread(() -> {
                if (tS.buyTicket()) {
                    System.out.println("Thread took ticket, left: " + tS.leftTickets);
                }
            });
        }

        for (int i = 0; i < nThreads; i++) {
            buyers[i].start();
        }
        for (int i = 0; i < nThreads; i++) {
            buyers[i].join();
        }

        System.out.println("tickets left: " + tS.leftTickets);
    }
}
