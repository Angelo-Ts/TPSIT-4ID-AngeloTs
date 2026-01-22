import javax.swing.*;

public class Main {
    public static void main (String[] args){
        JFrame f = new JFrame("Poligoni e Thread");
        f.setSize(990, 660);
        f.setLocationRelativeTo(null); // centra nel monitor
        f.add(new MyPanel());
        f.setVisible(true);

    }
}