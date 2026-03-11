package EsTimer;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class SpiraleSuperDidatticaColorata extends JPanel {

    // Tela dove disegniamo
    private final  BufferedImage tela;

    // Tartaruga
    private final Tartaruga t;

    // Colori ciclici
    private final Color[] colori = {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.CYAN,
            Color.BLUE,
            Color.MAGENTA
    };
    // gradi di rotazione della tartaruga
    private final double[] gradi = {45, 60, 89, 90, 91, 137,5};

    public SpiraleSuperDidatticaColorata() {
        // inizializzo tela e tartaruga
        tela = new BufferedImage(600,600,
                BufferedImage.TYPE_INT_ARGB);

        t = new Tartaruga(300,300,tela);

        // avvio ricorsione
        for ( int i=0; i<3; i++) {   // gradi.length
            System.out.println("Gradi di rotazione: " + gradi[i]);
            spirale(10, 25, 0, gradi[i]);
            t.sinistra(0); // reset angolo
        }
    }

    /*
     =======================================
     METODO RICORSIVO
     =======================================

     CASO BASE:
        passi == 0 → stop

     PROBLEMA PIÙ PICCOLO:
        - un passo in meno
        - segmento più lungo

     CHIAMATA RICORSIVA:
        spirale(lung+10, passi-1, colore+1)
    */
    private void spirale(double lung,
                         int passi,
                         int indiceColore,
                         double gradiRotazione) {

        // ===== CASO BASE =====
        if (passi == 0) {
            System.out.println("FINE");
            return;
        }

        Timer timer = new Timer(200, null);

        timer.addActionListener(e -> {

            // scelgo colore ciclico
            Color c =
                    colori[indiceColore % colori.length];

            // tartaruga avanti con colore
            t.avanti(lung, c);

            // gira di 90° quaddrato
            // gira di 60° triangolo
            // gira di 45° esagono
            // gira di 137.5° spirale aurea
            // gira di 89° spirale super didattica
            // gira di 91° spirale super didattica invertita
            t.sinistra(gradiRotazione);

            // ridisegno il pannello

            repaint();

            timer.stop();

            // ===== CHIAMATA RICORSIVA =====
            spirale(lung+10,
                    passi-1,
                    indiceColore+1,
                    gradiRotazione);
        });

        timer.setRepeats(false);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(tela,0,0,null);
    }


    // MAIN
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Spirale Colorata");
            f.add(new SpiraleSuperDidatticaColorata());
            f.setSize(600,600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }
}
