public class ThreadPoligono extends Thread {

    private String color;
    private int angle;
    private int lenght;
    private int x;
    private int y;
    private int n;

    public ThreadPoligono(String color, int angle, int lenght, int x, int y, int n) {
        this.color = color;
        this.angle = angle;
        this.lenght = lenght;
        this.x = x;
        this.y = y;
        this.n = n;
    }

    //calcolo lato

    @Override
    public void run() {

    }
}
