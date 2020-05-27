package listaenlazada;

import java.util.Iterator;

public class MyIteratorLinkedList<T> implements Iterator<T> {

    private NodoLista<T> nodo;

    public MyIteratorLinkedList(NodoLista<T> nodo) {
        this.nodo = nodo;
    }

    @Override
    public boolean hasNext() {

        return (nodo != null);
    }

    @Override
    public T next() {
        T valueToReturn = nodo.getValor();

        nodo = nodo.getSiguiente();

        return valueToReturn;
    }

}
