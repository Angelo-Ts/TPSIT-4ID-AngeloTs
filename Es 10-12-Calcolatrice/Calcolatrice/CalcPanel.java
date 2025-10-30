
import javax.swing.*;

class CalcPanel extends JPanel {
    JTextField txt;
    CalcButton sum, sub, mul, div, calc, canc;
    public CalcPanel(){
        super();
        txt = new JTextField(15);
        txt.setHorizontalAlignment(JTextField.RIGHT);
        calc = new CalcButton("=");
        sum = new CalcButton("+");
        sub = new CalcButton("-");
        mul = new CalcButton("*");
        div = new CalcButton("/");
        canc = new CalcButton("C");
        add(txt);
        add(sum); add(sub); add(mul);
        add(div); add(calc); add(canc);
        Calculator calcolatore = new Calculator(txt);
        // l'unico ascoltatore è questo oggetto
        // calclatore che gestisce tutti gli eventi
        // e rappresenta il vero e proprio calcolatore
        sum.addActionListener(calcolatore);
        sub.addActionListener(calcolatore);
        mul.addActionListener(calcolatore);
        div.addActionListener(calcolatore);
        calc.addActionListener(calcolatore);
        canc.addActionListener(calcolatore);
    }
}