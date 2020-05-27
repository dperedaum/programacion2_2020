package listaenlazada;

import lista.ElementoNoExiste;
import lista.MyList;
import lista.PosicionInvalida;
import stack.MyStack;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>, MyStack<T> {

    private NodoLista<T> primero;

    private NodoLista<T> ultimo;

    public MyLinkedList() {
        primero = null;
        ultimo = null;
    }

    public int add(T valor) {
        NodoLista nodo = new NodoLista(valor);

        if (ultimo == null) {
            ultimo = nodo;
            primero = ultimo;
        } else {

            ultimo.setSiguiente(nodo);
            ultimo = nodo;
        }

        return 0;
    }

    public void remove(int pos) throws ElementoNoExiste {
        // FIXME lo van a tener que hacer ustedes mismos.
    }

    @Override
    public void remove(T valor) throws ElementoNoExiste {
        // FIXME realizar en casa
    }

    public int size() {
        // FIXME lo van a tener que hacer ustedes mismos.
        throw new NotImplementedException();
    }

    public T get(int pos) throws PosicionInvalida {
        // FIXME lo van a tener que hacer ustedes mismos.
        return null;
    }

    @Override
    public boolean contains(T valor) {
        boolean contains = false;

        NodoLista<T> temp = this.primero;

        while(temp != null && !temp.getValor().equals(valor)) {
            temp = temp.getSiguiente();
        }

        if (temp != null) {
            contains = true;
        }

        return contains;
    }

    @Override
    public void push(T element) {
        add(element);
    }

    @Override
    public T pop() {
        T objectToReturn = null;

        try {

            objectToReturn = get(size());

            remove(size());

        } catch (PosicionInvalida e) {
            //FIXME
        } catch (ElementoNoExiste e) {
            // FIXME
        }

        return objectToReturn;
    }

    @Override
    public T top() {
        return ultimo.getValor();
    }

    @Override
    public Iterator<T> iterator() {

        return new MyIteratorLinkedList<>(primero);
    }
}
