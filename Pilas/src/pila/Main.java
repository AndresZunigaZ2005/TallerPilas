package pila;

public class Main {

    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(12);
        pila.apilar(78);
        pila.apilar(40);

        eliminarElementos(pila, 2, 4);

        // Imprimir la pila resultante
        System.out.println("Pila resultante:");
        for (Integer elemento : pila) {
            System.out.println(elemento);
        }
    }

    public static <T> void eliminarElementos(Pila<T> p, int nivelInf, int nivelSup) {
        Pila<T> temp = new Pila<>();
        int nivelActual = 1;

        // Pasar los elementos de la pila original a una temporal, hasta alcanzar nivelInf
        while (nivelActual < nivelInf && !p.isEmpty()) {
            temp.apilar(p.desapilar());
            nivelActual++;
        }

        // Eliminar los elementos entre nivelInf y nivelSup, inclusive
        while (nivelActual <= nivelSup && !p.isEmpty()) {
            p.desapilar();
            nivelActual++;
        }

        // Pasar de vuelta los elementos de la pila temporal a la original
        while (!temp.isEmpty()) {
            p.apilar(temp.desapilar());
        }
    }
}
