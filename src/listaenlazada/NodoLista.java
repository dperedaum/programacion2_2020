package listaenlazada;

public class NodoLista<T> {

    private T valor;

    private NodoLista siguiente;

    public NodoLista(T valor) {
        this.valor = valor;
        siguiente = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }
}
