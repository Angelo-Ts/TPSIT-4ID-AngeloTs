
public class Contatore {
    int valore;

    public Contatore(){
        valore = 0;
    }

    public void incrementa(){
        valore += 1;
    }

    public void decrementa(){
        valore -= 1;
    }

    public int getValore() {
        return valore;
    }
}
