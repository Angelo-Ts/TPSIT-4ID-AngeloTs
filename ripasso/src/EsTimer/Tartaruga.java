package EsTimer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/*
    =======================================
    CLASSE TARTARUGA
    =======================================
   */
public class Tartaruga {

    private double x,y;
    private double angolo;
    private final BufferedImage tela;

    public Tartaruga(double x,
                     double y,
                     BufferedImage tela) {
        this.x = x;
        this.y = y;
        this.tela = tela;
        angolo = 0;
    }

    /*
     Avanza e disegna con un colore
    */
    public void avanti(double lung,
                       Color colore) {

        Graphics2D g =
                (Graphics2D) tela.getGraphics();

        g.setColor(colore);

        double rad =
                Math.toRadians(angolo);

        double nx =
                x + Math.cos(rad)*lung;

        double ny =
                y + Math.sin(rad)*lung;

        g.drawLine((int)x,(int)y,
                (int)nx,(int)ny);

        x = nx;
        y = ny;

        g.dispose();
    }

    // gira a sinistra
    public void sinistra(double gradi){
        angolo -= gradi;
    }
    public void destra(double gradi){
        angolo += gradi;
    }
}