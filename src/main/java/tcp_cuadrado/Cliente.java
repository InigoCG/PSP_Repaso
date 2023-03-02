package tcp_cuadrado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;

        System.out.println("Cliente iniciado");
        Socket cliente = new Socket(host, puerto);
        try (DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
             DataInputStream entrada = new DataInputStream(cliente.getInputStream())){
            Scanner sc = new Scanner(System.in);
            String numero = null;
            do {
                System.out.println("Introduce un número:");
                numero = sc.next();
                salida.writeUTF(numero);

                System.out.println(entrada.readUTF());
            } while (!numero.equals("*"));

            sc.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println("Saliendo del cliente...");
        }
    }
}
