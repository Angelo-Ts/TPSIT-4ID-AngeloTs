public class MyPanel extends JPanel implements ActionListener {


    private JLabel l;
    public Es8Panel(){
        super();
        l = new JLabel("Tizio");
        add(l);
        JButton b = new JButton("Tizio/Caio");
        // Tizio/Caio è l'etichetta del pulsante
        b.addActionListener(this);
        // registra l'oggetto panel stesso come
        // ascoltatore degli eventi
add(b); }