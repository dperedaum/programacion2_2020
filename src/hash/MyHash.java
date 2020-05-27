package hash;

/**
 * Esta interfaz representa una estructura de Hash
 * @param <Key>
 * @param <Value>
 */
public interface MyHash<Key, Value> {

    /**
     * Esta operacion permite agregar un valor de clave K y valor V dentro de la estructura de Hash
     * @param k
     * @param v
     */
    void put(Key k, Value v);

    Value get(Key k);

    int size();

    void remove(Key k);

}
