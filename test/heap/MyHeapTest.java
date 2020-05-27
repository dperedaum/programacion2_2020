package heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyHeapTest {

    @Test
    public void testInsert() {
        MyHeap<Integer> myHeap = new MyHeapImpl<>(5);

        myHeap.insert(2);
        myHeap.insert(17);
        myHeap.insert(9);
        myHeap.insert(11);
        myHeap.insert(8);

        assertEquals(5, myHeap.size());

        assertEquals(17, myHeap.getMax());

        try {

            myHeap.insert(13);

            fail();

        } catch (HeapOverflow e0) {

            assertTrue(true);

        }

    }
}
