package tcp_hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente extends Thread {
    private Socket cliente;
    private DataOutputStream salida;
    private DataInputStream entrada;

    public HiloCliente(Socket socket) throws IOException {
        cliente = socket;

        salida = new DataOutputStream(cliente.getOutputStream());
        entrada = new DataInputStream(cliente.getInputStream());
    }

    @Override
    public void run() {
        try {
            String llegada = entrada.readUTF();
            salida.writeUTF(llegada.toUpperCase());

            entrada.close();
            salida.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println("Saliendo del cliente...");
        }
    }
}
