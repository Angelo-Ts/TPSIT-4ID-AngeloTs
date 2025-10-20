import java.awt.*;

public class App4{
    public static void main(String[] v){
        MyFrame f = new MyFrame("Esempio4");
        Container c = f.getContentPane();
        MyPanel panel = new MyPanel();
        c.add(panel);
        f.show();
    }
} 