import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(20,20,100,80);
        g.setColor(Color.blue);
        g.drawRect(30,30, 80,60);
        g.setColor(Color.black);
        g.drawString("Ciao", 50, 60);
    }
}