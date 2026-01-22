import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {


    public MyPanel(){
    }

    public void paint (Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(20,20, 100,80);
        g.setColor(Color.blue);
        g.drawRect(30,30, 80,60);
        g.setColor(Color.black);
        g.drawString("ciao",50,60);

    }

    /*
    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    // Area rettangolare
    int rectW = 990;
    int rectH = 660;

    // Area del triangolo
    double area = 72600;

    // Calcolo lato del triangolo equilatero
    double lato = Math.sqrt((4 * area) / Math.sqrt(3));

    // Altezza del triangolo
    double h = (Math.sqrt(3) / 2) * lato;

    // Offset per centrare il triangolo
    double offsetX = (rectW - lato) / 2;
    double offsetY = (rectH - h) / 2;

    // Vertici del triangolo (equilatero, punta in alto)
    int x1 = (int) (offsetX + lato / 2);
    int y1 = (int) (offsetY);

    int x2 = (int) (offsetX);
    int y2 = (int) (offsetY + h);

    int x3 = (int) (offsetX + lato);
    int y3 = (int) (offsetY + h);

    int[] x = { x1, x2, x3 };
    int[] y = { y1, y2, y3 };

    // Disegno
    g2.drawPolygon(x, y, 3);
    // g2.fillPolygon(x, y, 3); // se lo vuoi pieno
}
     */
}
