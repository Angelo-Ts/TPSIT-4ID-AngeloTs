public class ThreadPoligono extends Thread {

    private int angle;
    private int lenght;
    private int x;
    private int y;
    private int n;

    public ThreadPoligono(int angle, int lenght, int x, int y, int n) {
        this.angle = angle;
        this.lenght = lenght;
        this.x = x;
        this.y = y;
        this.n = n;
    }

    @Override
    public void run() {
        super.run();
    }
}
