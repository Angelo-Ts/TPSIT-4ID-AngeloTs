import java.awt.event.*;
import javax.swing.*;

public class SkyFrame extends JFrame {

    private StarPanel panel;
    private volatile boolean running = true;

    public SkyFrame() {
        setTitle("Cielo Stellato");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new StarPanel();
        add(panel);

        // Creazione stelle
        for (int i = 0; i < 50; i++) {
            Star s = new Star(panel, this);
            panel.addStar(s);
            s.start();
        }

        // Quando la finestra viene chiusa → ferma i thread
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                running = false;
            }
        });

        setVisible(true);
    }

    public boolean isRunning() {
        return running;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SkyFrame::new);
    }
}
