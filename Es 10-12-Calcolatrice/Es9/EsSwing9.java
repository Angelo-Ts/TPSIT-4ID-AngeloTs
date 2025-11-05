import java.awt.Container;
import javax.swing.JFrame;

public class EsSwing9 {
    public static void main(String[] v){
        JFrame f = new JFrame("Esempio 9");
        Container c = f.getContentPane();
        Es9Panel p = new Es9Panel();
        c.add(p);
        f.addWindowListener( new Terminator() );
        // Terminator è la classe che implementa
        // l'interfaccia WindowListener
        f.pack();
        f.show();
    }
}
