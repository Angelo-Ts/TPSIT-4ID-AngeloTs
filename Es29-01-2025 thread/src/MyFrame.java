import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyFrame extends JFrame {

    private final BufferedImage tela;
    private final Turtle turtle;
    JPanel p;

    private Color[] colors = {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.CYAN,
            Color.BLUE,
            Color.MAGENTA
    };


    public MyFrame(){
        tela = new BufferedImage(600,600,
                BufferedImage.TYPE_INT_ARGB);

        turtle = new Turtle(300,300,tela);

        spirale(20, 25, 0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(tela,0,0,null);
    }

    /*
        Timer timer = new Timer(200, null);
        timer.addActionListener(e ->{
            timer.stop();
        });
    */
}
