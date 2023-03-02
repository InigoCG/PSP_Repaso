package relevos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Testigo testigo = new Testigo();

        List<Corredor> lista = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lista.add(new Corredor(testigo, i));
            lista.get(i).start();
        }
        boolean aux = true;
        while (aux) {
            int contador = 0;
            for (Corredor corredor : lista) {
                if (!corredor.isAlive()) {
                    contador++;
                }
            }
            if (contador == lista.size()) {
                aux = false;
                System.out.println("Termina la carrera");
            }
        }
    }
}
