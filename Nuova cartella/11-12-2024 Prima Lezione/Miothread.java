
import java.util.Random;

// Creare un thread estendendo un thread

class Miothread extends Thread{
    private String nome;

    public Miothread(String nome){
        this.nome = nome;
    }

    //il metodo che ridefinisco si chiama run. ,a deve essere attivato
    //dal dispacher del sis. operativo, NON dal nostro codice direttamente
    //infatti nella CallMioThread lo avvio con il metodo start()

    @Override
    public void run(){
        Random a = new Random();
        for (int i = 1; i < 10; i++) {
            System.out.print(nome + ": iterazione " + i  + "\t");
            //addormento il tread per 500ms, quindi passo il controllo al sis. operativo
            try{
                //Thread.sleep(a.nextInt(100, 5000));
                Thread.sleep(500);
                System.out.println();  //pausa
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(nome + " terminato!");
    }

}