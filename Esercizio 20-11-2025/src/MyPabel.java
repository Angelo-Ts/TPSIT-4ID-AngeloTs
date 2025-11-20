
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPabel extends JPanel implements ActionListener{
    JButton[] bottoni;
    TextField[] testo;

    public MyPabel(){
        setLayout(new GridLayout(2, 5));

        bottoni = new JButton[5];
        testo = new TextField[5];

        for(int i = 0; i < bottoni.length; i++){
            bottoni[i] = new JButton("MAIUSCOLO");
            testo[i] = new TextField("testo");

            bottoni[i].addActionListener(this);

            this.add(bottoni[i]);
            

        }
        for (int i = 0; i < testo.length; i++) {
            this.add(testo[i]);
        }
    
    }

    public void actionPerformed(ActionEvent e){

        JButton b1 = (JButton)e.getSource();

        for (int i = 0; i < bottoni.length; i++) {
            if(bottoni[i] == b1){
                if(bottoni[i].getText().equals("MAIUSCOLO")){
                    //testo[i].setText(testo[i].getText().toUpperCase());
                    String s = testo[i].getText();
                    s = s.toUpperCase();
                    testo[i].setText(s);
    
                    bottoni[i].setText("minuscolo");
                } else{
                    String s = testo[i].getText();
                    s= s.toLowerCase();
                    testo[i].setText(s);
    
                    bottoni[i].setText("MAIUSCOLO");
                }
            }
        }
    }
}
