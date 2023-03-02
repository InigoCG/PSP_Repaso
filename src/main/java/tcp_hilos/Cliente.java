package tcp_hilos;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket("localhost", 6000);
        System.out.println("Cliente iniciado");

        HiloCliente hilo = new HiloCliente(cliente);
        hilo.start();

    }
}
