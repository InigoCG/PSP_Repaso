package tcp_cuadrado;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 6000;
        ServerSocket servidor = new ServerSocket(puerto);
        Socket cliente = null;
        System.out.println("Esperando cliente");
        cliente = servidor.accept();

        InputStream entrada = null;
        entrada = cliente.getInputStream();
        OutputStream salida = cliente.getOutputStream();
        try (DataInputStream flujoEntrada = new DataInputStream(entrada);
             DataOutputStream flujoSalida = new DataOutputStream(salida);){
            String lectura = "";
            while (!lectura.equals("*")) {
                lectura = flujoEntrada.readUTF();
                try {
                    int numero = Integer.parseInt(lectura) * Integer.parseInt(lectura);
                    flujoSalida.writeUTF("Me devuelve el servidor: " + numero);
                } catch (NumberFormatException e) {
                    if (!lectura.equals("*")) {
                        flujoSalida.writeUTF("ERROR");
                    }
                }
            }
            entrada.close();
            servidor.close();
        } catch (EOFException e) {

        }
    }
}
