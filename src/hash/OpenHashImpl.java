package hash;

import lista.ElementoNoExiste;
import lista.MyList;
import listaenlazada.MyLinkedList;

import java.util.Iterator;

public class OpenHashImpl<K, V> implements MyHash<K, V> {

    private MyList<HashEntry<K, V>>[] entryArray;

    private int size = 0;

    public OpenHashImpl(int size) {
        this.entryArray = new MyList[size];
    }

    @Override
    public void put(K k, V v) {
        int position = k.hashCode() % entryArray.length;

        MyList<HashEntry<K, V>> listForPosition = entryArray[position];

        if (listForPosition == null) {

            listForPosition = new MyLinkedList<>();
            entryArray[position] = listForPosition;

        }

        // Busco la entrada si existe la actualizo si no creo una nueva
        Iterator<HashEntry<K, V>> iterator = listForPosition.iterator();
        HashEntry<K, V> searchElement = null;

        while (iterator.hasNext() && searchElement == null) {
            HashEntry<K, V> tempValue = iterator.next();

            if (tempValue.getKey().equals(k)) {
                searchElement = tempValue;
            }
        }

        // Si encontre el elemento actualizo la value
        if (searchElement != null) {
            searchElement.setValue(v);
        } else {
            // si no existe lo creo y lo agrego a la lista
            HashEntry<K, V> hashEntry = new HashEntry<>(k, v);

            listForPosition.add(hashEntry);
            size++;
        }
    }

    @Override
    public V get(K k) {
        int position = k.hashCode() % entryArray.length;
        V valueToReturn = null;

        MyList<HashEntry<K, V>> listForPosition = entryArray[position];

        if (listForPosition != null) {
            // Buscar si existe la entrada con clave k
            for (HashEntry<K, V> tempEntry : listForPosition) {

                if (tempEntry.getKey().equals(k)) {
                    valueToReturn = tempEntry.getValue();
                }

            }
        }

        return valueToReturn;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void remove(K k) {
        int position = k.hashCode() % entryArray.length;

        MyList<HashEntry<K, V>> listForPosition = entryArray[position];

        if (listForPosition != null) {
            int positionToRemove = -1;
            int i = 0;

            // Buscar si existe la entrada con clave k

            try {

                HashEntry<K, V> temp  = new HashEntry<>(k, null);

                listForPosition.remove(temp);

            } catch (ElementoNoExiste elementoNoExiste) {
                throw new RuntimeException(elementoNoExiste);
            }

        }
    }
}
