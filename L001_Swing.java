import java.awt.*;
import javax.swing.*;

public class L001_Swing{
    public static void main (String[] v) {
        JFrame f = new JFrame("Esempio 1");
        f.show();                           // rende visibile 

        f.setSize(new Dimension(300, 150)); //x,y misure in pixel
        f.setLocation(200,100);         //(0,0) angolo superiore sinistro

        //f.setBounds(200, 100, 300, 150);  //serve per unire i comandi size e location (x,y, width, height)
    }
}