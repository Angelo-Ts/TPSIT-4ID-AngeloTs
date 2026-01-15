import javax.swing.*;

public class Main {
    public static void main (String[] args){
        JFrame f = new JFrame("Poligoni e Thread");
        f.setBounds(JWindow.WIDTH -  512, (JWindow.HEIGHT/2),1024, 770);

        f.add(new MyPanel());
        f.setVisible(true);

    }
}