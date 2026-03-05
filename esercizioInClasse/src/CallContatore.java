
public class CallContatore {
    public static void main(String[] args) throws InterruptedException {
        int incremento = Math.random() < 0.5 ? 5000 : 10000;
        Contatore c = new Contatore();

        Thread t1 = new Thread( () -> {
            for (int i = 0; i < incremento; i++){
                c.incrementa();
            }
        });

        Thread t2 = new Thread( () -> {
            for (int i = 0; i < incremento; i++){
                c.incrementa();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Il numero dovrebbe essere :" + incremento * 2 + " invece è: " + c.getValore());
    }
}