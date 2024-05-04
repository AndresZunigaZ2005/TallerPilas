package pilaTamanioFijo;

public class Main {

    public static void main(String[] args) {
        PilaTamanioFijo<Integer> pila = new PilaTamanioFijo<>(10);
        try {
			pila.apilar(10);
	        pila.apilar(20);
	        pila.apilar(12);
	        pila.apilar(78);
	        pila.apilar(40);
		} catch (PilaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        eliminarElementos(pila, 2, 4);

        // Imprimir la pila resultante
        System.out.println("Pila resultante:");
        for (Integer elemento : pila) {
            System.out.println(elemento);
        }
    }

    public static <T> void eliminarElementos(PilaTamanioFijo<T> p, int nivelInf, int nivelSup) {
        PilaTamanioFijo<T> temp = new PilaTamanioFijo<>(p.getCapacidad());
        int nivelActual = 1;

        // Pasar los elementos de la pila original a una temporal, hasta alcanzar nivelInf
        while (nivelActual < nivelInf && !p.isEmpty()) {
            try {
                temp.apilar(p.desapilar());
            } catch (PilaException e) {
                e.printStackTrace();
            }
            nivelActual++;
        }

        // Eliminar los elementos entre nivelInf y nivelSup, inclusive
        while (nivelActual <= nivelSup && !p.isEmpty()) {
            try {
                p.desapilar();
            } catch (PilaException e) {
                e.printStackTrace();
            }
            nivelActual++;
        }

        // Pasar de vuelta los elementos de la pila temporal a la original
        while (!temp.isEmpty()) {
            try {
                p.apilar(temp.desapilar());
            } catch (PilaException e) {
                e.printStackTrace();
            }
        }
    }
}
