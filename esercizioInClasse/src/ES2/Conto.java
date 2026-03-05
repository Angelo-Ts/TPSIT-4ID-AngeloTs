public class Conto {
    private int saldo;

    public Conto() {
        this.saldo = 10000;
    }

    public synchronized boolean preleva(int importo) {
        if (saldo >= importo) {
            saldo -= importo;
            System.out.println(Thread.currentThread().getName() + " ha prelevato " + importo + " - Saldo: " + saldo);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " Non può prelevare " + importo + " - Saldo insufficiente: " + saldo);
            return false;
        }
    }

    public synchronized int getSaldo() {
        return saldo;
    }
}

