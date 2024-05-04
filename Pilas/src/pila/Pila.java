package pila;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pila<T> implements Iterable<T> {

    private NodeGeneric<T> headNode;
    private int size;

    public Pila() {
        headNode = null;
        size = 0;
    }

    public void apilar(T dato) {
        NodeGeneric<T> nuevoNodo = new NodeGeneric<>(dato);
        nuevoNodo.setNext(headNode);
        headNode = nuevoNodo;
        size++;
    }

    public T desapilar() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        NodeGeneric<T> aux = headNode;
        headNode = headNode.getNext();
        size--;
        return aux.getData();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return headNode.getData();
    }

    public void borrarPila() {
        headNode = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new PilaIterator();
    }

    private class PilaIterator implements Iterator<T> {
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

