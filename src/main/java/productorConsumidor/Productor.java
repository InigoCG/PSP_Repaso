package productorConsumidor;

public class Productor extends Thread{
    private Documento documento;

    public Productor(Documento documento) {
        this.documento = documento;
    }

    @Override
    public void run() {
        while (true) {
            try {
                documento.escribir();
                sleep(1000);
            }  catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
