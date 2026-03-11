package Es2_CieloStellato_currenThread;

public class Star extends Thread {

    private StarPanel panel;

    private SkyFrame frame;



    public Star(StarPanel panel, SkyFrame frame) {

        this.panel = panel;

        this.frame = frame;

    }



    @Override

    public void run() {

        while (frame.isRunning()) {

            // Logic for star movement

            panel.repaint();

            try {

                Thread.sleep(100); // Adjust sleep time as needed

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

            }

        }

    }

}
