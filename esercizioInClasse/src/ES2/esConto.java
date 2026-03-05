public class esConto {
    public static void main(String[] args) throws InterruptedException {
        Conto conto = new Conto();
        prelievo p = new prelievo();

        Thread t1 = new Thread( () -> {
            conto.preleva(p.preleva());
        }, "Thread-1");

        Thread t2 = new Thread( () -> {
            conto.preleva(p.preleva());
        }, "Thread-2");

        Thread t3 = new Thread( () -> {
            conto.preleva(p.preleva());
        }, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Saldo finale: " + conto.getSaldo());
    }
}
