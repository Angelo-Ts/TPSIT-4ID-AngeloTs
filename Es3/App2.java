import java.awt.Rectangle;

public class App2 {
    public static void main(String[] v){
        MyFrame f = new MyFrame();
        f.show();
        MyFrame c = new MyFrame("App2");
        c.show();
        MyFrame d = new MyFrame("App2", new Rectangle(200,100,820,400));
    }
}
