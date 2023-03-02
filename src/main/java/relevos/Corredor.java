package relevos;

public class Corredor extends Thread {
    private Testigo testigo;
    private int contador;

    public Corredor(Testigo testigo, int contador) {
        this.testigo = testigo;
        this.contador = contador;
    }
    boolean corriendo = true;

    @Override
    public void run() {
        while (corriendo) {
            if (testigo.estaSuspendido()) {
                try {
                    testigo.esperando();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                testigo.set(true);
                System.out.println("Corredor: " + contador + " está corriendo");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Corredor: " + contador + " ha dejado de correr");
                corriendo = false;
                testigo.set(false);
            }
        }
    }
}
