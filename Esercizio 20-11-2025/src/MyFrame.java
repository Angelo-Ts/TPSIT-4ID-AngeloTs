
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class MyFrame extends JFrame implements ActionListener{
    JTextField  t1;
    JTextField t2;

    public MyFrame(){
        super("FINESTRA 1");
        setSize(500, 300);
        JPanel bottoni = new JPanel();
        JPanel testo = new JPanel();

        setLayout(new GridLayout(1, 2));

        JButton b1 = new JButton("INVIA");
        JButton b2 = new JButton("CANCELLA");
        b1.addActionListener(this);
        b2.addActionListener(this);

        t1 = new JTextField("scrivi un testo");
        t2 = new JTextField("scrivi un testo");

        bottoni.add(b1);
        bottoni.add(b2);
        
        testo.add(t1);
        testo.add(t2);

        bottoni.setLayout(new GridLayout(2, 1));
        testo.setLayout(new GridLayout(2, 1));


        add(bottoni);
        add(testo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b1 = (JButton)e.getSource();

        if(b1.getText().equals("INVIA")){
            JDialog d1 = new JDialog();
            d1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            d1.setSize(250, 250);
            d1.add(new JLabel(t1.getText()));
            d1.add(new JLabel(t2.getText()));
            d1.setVisible(true);
        } else {
            t2.setText("scrivi un testo");
            t1.setText("scrivi un testo");
        }
    }
}
