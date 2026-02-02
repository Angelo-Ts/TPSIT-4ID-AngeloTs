import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Turtle extends JPanel{
    private double x, y;
    private double angle;
    private boolean isPenDown;
    private Color color;
    private final BufferedImage tela;

    public Turtle(double x, double y, BufferedImage tela) {
        this.x = x;
        this.y = y;
        this.angle = 0;
        this.isPenDown = true;
        this.color = color;
        this.tela = tela;
    }

    public void forward (double len){
        Graphics2D g = (Graphics2D) tela.getGraphics();

        double radians = (Math.PI / 180) * this.angle;
        double deltaX = Math.cos(radians) * len;
        double deltaY = Math.sin(- radians) * len;

        double newX = this.x + deltaX;
        double newY = this.y + deltaY;

        if (this.isPenDown) {
            g.setColor(this.color);
            g.drawLine((int) x, (int) y, (int) newX, (int) newY);
        }
        this.x = newX;
        this.y = newY;

        g.dispose();
    }

    public void turn (double a){
        this.angle += a;
        if (this.angle >= 360) {
            this.angle -= 360;
        }
    }

    public void penUp(){
        this.isPenDown = false;
    }

    public void penDown(){
        this.isPenDown = true;
    }

    public void changeColor(Color color){
        this.color = color;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }
}