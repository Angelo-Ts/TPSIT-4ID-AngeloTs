
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;



public class StarPanel extends JPanel {

    private List<Star> stars = new ArrayList<>();



    public void addStar(Star star) {

        stars.add(star);

    }



    @Override

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Logic to draw stars

    }

}
