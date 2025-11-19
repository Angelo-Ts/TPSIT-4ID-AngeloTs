import java.awt.*;
import javax.swing.JFrame;

public class Main{
    public static void main(String[] v){
        JFrame f = new JFrame("Verifica");
        f.setSize(1200, 800);
        Container c = f.getContentPane();

        MyPanel p = new MyPanel();
        c.add(p);
        f.show();
    }
}