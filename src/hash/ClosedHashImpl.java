package hash;

public class ClosedHashImpl<Key, Value> implements MyHash<Key, Value> {

    private static int LINEAL_COLLISION_FUNCTION = 1;

    private HashEntry<Key, Value>[] hashTable;

    private int size;

    private int defaultCollisionFunction = ClosedHashImpl.LINEAL_COLLISION_FUNCTION;

    public ClosedHashImpl(int size) {
        this.hashTable = new HashEntry[size];
    }

    @Override
    public void put(Key k, Value v) {
        int attempt = 0;
        int position = internalHashcodeWithCollision(k, attempt);

        HashEntry<Key, Value> valueToInsert = new HashEntry<>(k, v);

        while (hashTable[position] != null &&
                !hashTable[position].isRemoved() &&
                !hashTable[position].getKey().equals(k) &&
                !(attempt > hashTable.length)) {

            attempt++;
            position = internalHashcodeWithCollision(k, attempt);

        }

        if (attempt > hashTable.length) {

            throw new RuntimeException("No se encontro lugar disponible");
        }

        if (hashTable[position] == null || hashTable[position].isRemoved()) {

            hashTable[position] = valueToInsert;

        } else { // Si sale por aca es porque ya existe un elemento en la clave con lo que hay que sustituir el valor

            hashTable[position].setValue(v);
        }

        size++;
    }

    @Override
    public Value get(Key k) {
        int attempt = 0;
        int position = internalHashcodeWithCollision(k, attempt);
        Value valueToReturn = null;

        while (hashTable[position] != null &&
                !hashTable[position].getKey().equals(k) &&
                !(attempt > hashTable.length)) {

            attempt++;
            position = internalHashcodeWithCollision(k, attempt);

        }

        if (hashTable[position] != null &&
                !(attempt > hashTable.length) &&
                hashTable[position].getKey().equals(k) &&
                !hashTable[position].isRemoved()) {

            valueToReturn = hashTable[position].getValue();

        }

        return valueToReturn;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void remove(Key k) {

    }

    private int internalHashcodeWithCollision(Key k, int attempt) {
        return (k.hashCode() + collisionFunction(attempt)) % hashTable.length;
    }

    private int collisionFunction(int i) {
        int value = 0;

        if (defaultCollisionFunction == LINEAL_COLLISION_FUNCTION) {

            value = i;

        }

        return value;
    }
}
