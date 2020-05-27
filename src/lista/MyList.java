package lista;

public interface MyList<TT> extends Iterable<TT> {

    int add(TT valor);

    void remove(int pos) throws ElementoNoExiste;

    void remove(TT valor) throws ElementoNoExiste;

    int size();

    TT get(int pos) throws PosicionInvalida;

    boolean contains(TT valor);

}
