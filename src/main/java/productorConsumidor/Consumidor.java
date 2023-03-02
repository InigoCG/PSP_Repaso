package productorConsumidor;

import java.io.IOException;

public class Consumidor extends Thread{
    private Documento documento;

    public Consumidor(Documento documento) {
        this.documento = documento;
    }

    @Override
    public void run() {
        while (true) {
            try {
                documento.leer();
                sleep(1000);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
