
import java.awt.*;
import javax.swing.*;

public class MainCalc {
    public static void main(String[] v){
        JFrame f = new JFrame("Mini-calcolatrice");
        Container c = f.getContentPane();
        CalcPanel p = new CalcPanel();
        c.add(p);
        f.setSize(220,150);
        f.addWindowListener(new Terminator());
        // Per gestire la chiusura della finestra
        f.show();
    }
}