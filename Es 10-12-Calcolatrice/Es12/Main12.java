
import java.awt.*;
import javax.swing.*;

public class Main12 {
    public static void main(String[] v){
        JFrame f = new JFrame("Esempio 12");
        Container c = f.getContentPane();
        Es12Panel p = new Es12Panel();
        c.add(p);
        f.addWindowListener( new Terminator() );
        f.setSize(300,120);
        f.show();
    }
}