
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main{
    public static void main(String[] args){
        JFrame j = new JFrame("Es Immagini griglia");
        j.setBounds(600, 300, 1200, 600);
        j.setLayout(new GridLayout (2, 4));
        Container c = j.getContentPane();
        c.add(new JLabel(new ImageIcon("img1.jpg"))); 
        j.pack(); 
        j.show(); 
    }
}