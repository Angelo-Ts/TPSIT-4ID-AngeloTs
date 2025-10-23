

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Es9Panel extends JPanel implements ActionListener {
    JButton b1, b2;
    public Es9Panel(){
        super();
        b1 = new JButton("Rosso");
        b2 = new JButton("Azzurro");
        b1.addActionListener(this);
        b2.addActionListener(this);
        // il pannello fa da ascoltatore degli
        // eventi per entrambi i pulsanti
        add(b1);
        add(b2);

    }
    public void actionPerformed(ActionEvent e){
        Object pulsantePremuto = e.getSource();
        // si recupera il riferimento all'oggetto
        // che ha generato l'evento
        if (pulsantePremuto==b1){
            // e si confronta questa con i riferimenti
            // agli oggetti bottoni b1 e b2
            setBackground(Color.red);
        }
        if (pulsantePremuto==b2){
            setBackground(Color.cyan);
        }
        
    }
}