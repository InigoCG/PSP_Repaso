package productorConsumidor;

public class Main {
    public static void main(String[] args) {
        Documento documento = new Documento();

        Productor productor = new Productor(documento);
        Consumidor consumidor = new Consumidor(documento);

        productor.start();
        consumidor.start();
    }
}
