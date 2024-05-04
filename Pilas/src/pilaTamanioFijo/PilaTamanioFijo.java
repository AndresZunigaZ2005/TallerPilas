package pilaTamanioFijo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PilaTamanioFijo<T> implements Iterable<T> {

    private NodeGeneric<T> headNode;
    private int size;
    private int capacidad;

    public PilaTamanioFijo(int capacidad) {
        headNode = null;
        size = 0;
        this.capacidad = capacidad;
    }
    
    

    private NodeGeneric<T> getHeadNode() {
		return headNode;
	}

	private void setHeadNode(NodeGeneric<T> headNode) {
		this.headNode = headNode;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public void apilar(T dato) throws PilaException {
        NodeGeneric<T> nuevoNodo = new NodeGeneric<T>(dato);
        nuevoNodo.next = headNode;
        if (isEmpty()) {
            this.headNode = nuevoNodo;
        } else {
            nuevoNodo.setNext(headNode);
            this.headNode = nuevoNodo;
        }
        size++;
        capacidad--;
    }

    public T desapilar() throws PilaException {
        if (isEmpty()) {
            throw new PilaException("La pila está vacía");
        }
        NodeGeneric<T> aux = headNode;
        headNode = headNode.next;
        size--;
        capacidad++;
        return aux.getData();
    }

    public T peek() {
        return headNode.getData();
    }

    public void borrarPila() {
        int nuevaCapacidad = 1;
        NodeGeneric<T> auxNode = headNode;
        while (auxNode.next != null) {
            auxNode = auxNode.next;
            nuevaCapacidad++;
        }
        headNode = null;
        capacidad += nuevaCapacidad;
        size = 0;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    public boolean isFull() {
        return size == capacidad;
    }

    public void printList() {
        NodeGeneric<T> aux = headNode;
        while (aux != null) {
            System.out.println(aux.getData());
            aux = aux.getNext();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new PilaTamanioFijoIterator();
    }

    private class PilaTamanioFijoIterator implements Iterator<T> {
        private NodeGeneric<T> current = headNode;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}

	
	
	
	/**
	 * Los operandos para las pilas:
	 *  
	 * Notación infija: Se usan parentesis para agrupar las operaciones, si se agrupa mal,
	 * la expresión queda mal 
	 * 
	 * Notación Polaca o prefija: El operador va antes de los operandos (usar siempre los
	 * parentesis)
	 * ej: a+b = +ab,  a+(b*c)=a+(*bc)=+a*bc 
	 * 
	 * Notacion Polaca inversa o postFija: primera van los operandos y luego los operadores
	 * 
	 * 
	 * Evaluación de una expresión artimetica de un procesador: transformar de infija a postfija
	 * y se evalua
	 */

