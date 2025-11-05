import javax.swing.*;
import javax.swing.event.*;
// solito main...

class Es12Panel extends JPanel implements DocumentListener {
    // deve implementare l'interfaccia
    JTextField txt1, txt2;
    
    public Es12Panel(){
        super();
        txt1= new JTextField("Scrivere qui il testo", 25);
        txt2 = new JTextField(25);
        txt2.setEditable(false);
        txt1.getDocument().addDocumentListener(this);
        // ricava il documento di cui il campo
        // di test txt1 fa parte e gli associa il
        // pannello come listener
        add(txt1);
        add(txt2);
    }

    // La gestione dell'evento:
    public void insertUpdate(DocumentEvent e){
        txt2.setText(txt1.getText()); 
    }

    public void removeUpdate(DocumentEvent e){
        txt2.setText(txt1.getText());
    }

    public void changedUpdate(DocumentEvent e){
        
    }
}

// implementazione formale

