import java.awt.*;
import javax.swing.*;

public class Main10 {
    public static void main(String[] v){
        JFrame f = new JFrame("Esempio 10");
        Container c = f.getContentPane();
        Es10Panel p = new Es10Panel();
        c.add(p);
        f.addWindowListener( new Terminator() );
        f.setSize(300,120);
        f.show();
    }
}