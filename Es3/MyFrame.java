import java.awt.Rectangle;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

    public MyFrame(){
        super(); setBounds(200,100,300,150); //super 
    }
    
    public MyFrame(String titolo){
        super(titolo);
        setBounds(200,100,300,150);
    }

    public MyFrame (String titolo, Rectangle dimensioni){
        super(titolo);
        setBounds(dimensioni);
    }
}