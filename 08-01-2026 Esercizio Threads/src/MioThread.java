class MioThread extends Thread {
    private String nome;

    public MioThread(String nome) {
        this.nome = nome;
    }

    // Attenzione il metodo che ridefinisco si chiama run ma deve essere attivato 
    // dal dispacher del sistema operativo NON dal nostro codice direttamente
    // infatti nella CallMioThread lo avvio con il metodo start()
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nome + ": iterazione " + i);
            // addormento il thread per 500ms, quindi passo il controllo al sistema operativo
            try {
                Thread.sleep(500); // Pausa di 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nome + " terminato!");
    }
}