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

    public void spirale(double lung, int passi, int iColore){
        if (passi == 0) {
            System.out.println("FINE");
            return;
        }

        Timer timer = new Timer(200, null);

        timer.addActionListener(e -> {

            // scelgo colore ciclico
            Color c =
                    colors[iColore % colors.length];

            // tartaruga avanti con colore
            turtle.changeColor(colors [iColore]);
            turtle.forward(lung);

            // gira di 60°
            turtle.turn(60);

            repaint();

            timer.stop();

            // ===== CHIAMATA RICORSIVA =====
            spirale(lung+10,
                    passi-1,
                    iColore+1);
        });

        timer.setRepeats(false);
        timer.start();
    }


    public static void main(String[] args){

        JFrame f =
                new JFrame("Spirale Colorata");

        f.add(new MyFrame());
        f.setSize(600,600);
        f.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
