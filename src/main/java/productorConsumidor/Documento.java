package productorConsumidor;

import java.io.*;

public class Documento {
    File documento = new File("src/main/resources/documento.txt");

    public Documento() {
    }

    public void escribir () {
        synchronized (documento) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(documento))) {
                bw.write("hola");
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("EL PRODUCTOR ESCRIBE");
        }
    }

    public void leer () throws IOException {
        synchronized (documento) {
            try (BufferedReader br = new BufferedReader(new FileReader(documento))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            }
        }
    }
}
