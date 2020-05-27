package stack;

import listaenlazada.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    private MyStack<Integer> stack;

    @BeforeEach
    void setUp() {
        stack = new MyLinkedList<>();
    }

    @Test
    void push_basic() {
        Integer number = 4;

        stack.push(number);

        assertEquals(number, stack.top());
    }

    @Test
    void push_basic_2() {
        Integer number = 4;
        Integer number2 = 5;

        stack.push(number);
        stack.push(number2);

        assertEquals(number2, stack.top());
    }

    @Test
    void testIterator() {
        Integer number = 4;
        Integer number2 = 5;

        stack.push(number);
        stack.push(number2);

        Iterator<Integer> iter = stack.iterator();

        assertTrue(iter.hasNext());
        assertEquals(4, iter.next());

        assertTrue(iter.hasNext());
        assertEquals(5, iter.next());

        assertFalse(iter.hasNext());
    }

    @Test
    void testForEach() {
        Integer number = 4;
        Integer number2 = 5;

        stack.push(number);
        stack.push(number2);

        for (Integer temp : stack) {
            System.out.println(temp);
        }

    }
}