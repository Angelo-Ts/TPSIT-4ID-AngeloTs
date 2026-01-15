
import javax.swing.JFrame;

public class Main{
    public static void main(String[] arg){

        JFrame f = new JFrame("Esercizio");
        f.setSize(1020, 550);
    
        f.add(new MyPabel());
        
        f.setVisible(true);

        MyFrame f2 = new MyFrame();
        f2.setVisible(true);
    }
}