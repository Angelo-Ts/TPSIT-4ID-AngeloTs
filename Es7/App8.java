import MyPanel;
class App8 extends MyPanel
    implements ActionListener {
    JButton b;
    JTextField txt1, txt2;
    public Es10Panel(){
    super();
    b = new JButton("Aggiorna");
    txt1=new JTextField("Scrivere qui il testo", 25);
    txt2 = new JTextField(25); // larghezza in caratt.
    txt2.setEditable(false); // non modificabile
    b.addActionListener(this);
    add(txt1);
    add(txt2);
    add(b);
}