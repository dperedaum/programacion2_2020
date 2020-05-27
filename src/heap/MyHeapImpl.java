package heap;

public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T> {

    private T[] values;

    private int pointerLastValue;

    public MyHeapImpl(T[] values) {
        this.values = values;
        pointerLastValue = 0;
    }

    public MyHeapImpl(int size) {
        this.values = (T[]) new Comparable[size];
    }

    @Override
    public void insert(T value) {

        if (pointerLastValue == values.length) {

            throw new HeapOverflow();
        }

        this.values[pointerLastValue] = value;
        int valuePosition = pointerLastValue;
        pointerLastValue++;

        while (valuePosition != 0 && value.compareTo(getFather(valuePosition)) > 0) {
            T tempValue = getFather(valuePosition);

            this.values[getFatherPosition(valuePosition)] = value;
            this.values[valuePosition] = tempValue;

            valuePosition = getFatherPosition(valuePosition);
        }

    }

    @Override
    public int size() {
        return pointerLastValue;
    }

    @Override
    public T getMax() {
        T valueToReturn = null;

        if (pointerLastValue != 0) {
            valueToReturn = this.values[0];
        }

        return valueToReturn;
    }

    @Override
    public void deleteMax() {

    }

    private T getFather(int childPosition) {
        return values[(childPosition - 1)/2];
    }

    private int getFatherPosition(int childPosition) {
        return (childPosition - 1)/2;
    }
}
