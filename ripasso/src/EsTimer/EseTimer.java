package EsTimer;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class EseTimer {

    static void controlloEDT() {
        if (SwingUtilities.isEventDispatchThread()) {
            System.out.println("Siamo nel thread dell'EDT: ");
        } else {
            System.out.println("Non siamo nel thread dell'EDT: ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int contatore = 0;
        // controllo se siamo nel thread dell'EDT Event Dispatch Thread
        System.out.println("Inizio: " + contatore++);
        controlloEDT();
        // Creo una finestra per permettere al Timer di funzionare correttamente    
        // senza di essa il Timer non funziona.
        // Il Timer utilizza il thread dell'Event Dispatch Thread (EDT) di Swing
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setSize(300,300);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            controlloEDT();
        });
        System.out.println("Finestra attiva: " + contatore++);
        controlloEDT();
        // Creo un Timer che stampa "Tick" ogni 200 millisecondi
        Timer t = new Timer(200, e -> {
            System.out.println("Tick");
            controlloEDT();
        }) ;
        // Avvio il Timer
        System.out.println("Attivo Timer: " + contatore++);
        t.start();

        System.out.println("Timer attivato"+ contatore++);
        System.out.println("sospendo il main, ovvero il Thread principale" + contatore++);
        // Lascio il Timer attivo per 2 secondi
        Thread.sleep(2000);  // EDT continua a funzionare 
        // e il Timer continua a generare eventi
        t.stop();
        controlloEDT();
        System.out.println("Timer stopped"+ contatore++);
    }
}