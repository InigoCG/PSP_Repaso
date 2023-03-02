package tcp_hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HiloServidor extends Thread {
    private Socket socket;
    private ServerSocket servidor;
    private DataInputStream entrada;
    private DataOutputStream salida;
    private Scanner sc = new Scanner(System.in);

    public HiloServidor(Socket cliente, ServerSocket servidor) throws IOException {
        socket = cliente;
        this.servidor = servidor;
        entrada = new DataInputStream(socket.getInputStream());
        salida = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        String cadena = "";
        do {
            System.out.println("Introduce un texto: ");
            cadena = sc.nextLine();
            try {
                salida.writeUTF(cadena);
                System.out.println("El cliente devuelve: " + entrada.readUTF());

                salida.close();
                entrada.close();
                sc.close();
                socket.close();
                servidor.close();
            } catch (Exception e) {
                System.out.println("Cerrando servidor...");
            }
        } while (cadena.equals("*"));
    }
}
