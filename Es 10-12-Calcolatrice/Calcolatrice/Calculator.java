
import java.awt.event.*;
import javax.swing.JTextField;

class Calculator implements ActionListener {
    double res = 0; JTextField display;
    String opPrec = "nop";
    public Calculator(JTextField t) { 
        display = t; 
    }
        
    public void actionPerformed(ActionEvent e){
        double valore =
        Double.parseDouble(display.getText());
        // recupera il valore dal campo di testo
        // e lo converte da stringa a double
        display.setText("");
        display.requestFocus();
        // fa si' che il campo di testo sia già
        // selezionato, pronto per scriverci dentro
        String operazione = e.getActionCommand();
        // recupera il nome del pulsante premuto
        // e' un modo alternativo per capire, tra tanti
        // bottoni, quale e' ha generato l'evento
        if (operazione.equals("C")) {       //cancella tutto
            res = valore = 0; opPrec = new String("nop");
        } else {                                    // esegui l'operazione precedente
            if (opPrec.equals("+")) res += valore; else
            if (opPrec.equals("-")) res -= valore; else
            if (opPrec.equals("*")) res *= valore; else
            if (opPrec.equals("/")) res /= valore; else
            if (opPrec.equals("nop")) res = valore;
            display.setText(""+res);
            opPrec = operazione;
            //la prossima operazione da eseguire è la corrente
        } 
    } 
}