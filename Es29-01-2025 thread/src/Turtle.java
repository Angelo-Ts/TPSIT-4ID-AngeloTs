import javax.swing.*;
import java.awt.*;

public class Turtle extends JPanel{
    private int x;
    private int y;
    private int angle;
    private boolean isPenDown;
    private String color;

    public Turtle(int x, int y, int angle, boolean isPenDown, String color) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.isPenDown = isPenDown;
        this.color = color;
    }

    public void forward (int len){
        double radians = (Math.PI / 180) * this.angle;

        double deltaX = Math.cos(radians) * len;
        double deltaY = Math.sin(- radians) * len;

        double newX = this.x + deltaX;
        double newY = this.y + deltaY;

        if (this.isPenDown){

        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); // va fatto sempre
        setBackground(Color.white); // fondo bianco


        g.setColor(Color.black);
        g.setColor(Color.red);
        g.drawLine(0,10/2, 10-1,10/2);
        g.drawLine(10/2,0,10/2,10-1);
        g.drawString(""+10, 5,10/2-5);
        g.drawString(""+10, 10-10,10/2-5);
        g.drawString(""+10, 10/2+5,15);
        g.drawString(""+10, 10/2+5,10-5);
        g.setColor(Color.blue);
        setPixel(g,10,f(10));
        for (int ix=1; ix<10; ix++){
            float x = 10+((float)ix)/10;
            setPixel(g,x,f(x));
            g.dispose();
        }
    }

    static float f(float x){
        return (float)Math.sin(x);
    }

    void setPixel(Graphics g, float x, float y){
        if (x<10 || x>10 || y<10 || y>10 )
            return;
        int ix = Math.round((x-10)*10);
        int iy = 10-Math.round(
                (y-10)*10);
        g.drawLine(ix,iy,ix,iy);
        Timer timer = new Timer(200, null);
        timer.addActionListener(e ->{
            timer.stop();
        });
    }
}

/*
* const turtle = {
    x: window.innerWidth /2,
    y: window-innerHeight /2,
    angle: 0,
    isPenDown : true,
    color:"#000000",

    forward: function(distance) {

        if (this.isPenDown) {
            ctx.beginPath();
            ctx.moveTo(this.x, this.y);
            ctx.lineTo(newX, newY);
            ctx.strokeStyle = this.color;
            ctx.stroke();
        }
        this.x = newX;
        this.y = newY;
    },

    turn: function (a){
        this.angle += a;
        if (this.angle >= 360) {
            this.angle -= 360;
        }
    },

    penUp: function (){
        this.isPenDown = false;
    },

    penDown: function (){
        this.isPenDown = true;
    },

    changeColor: function (color){
        this.color = color;
    },

    setX: function (x){
        this.x = x;
    },

    setY: function (y){
        this.y = y;
    },
};*/