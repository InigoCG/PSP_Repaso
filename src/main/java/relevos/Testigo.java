package relevos;

public class Testigo {
    private boolean suspendido;
    public synchronized void set(boolean setter) {
        suspendido = setter;
        notifyAll();
    }
    public synchronized void esperando () throws InterruptedException {
        while (suspendido)
            wait();
    }
    public boolean estaSuspendido () {
        return suspendido;
    }
}
