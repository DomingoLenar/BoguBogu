package testcases;
import static org.junit.Assert.*;
import datastruc.SingleLinkedList;
import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {

    public SingleLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new SingleLinkedList<>();
    }

    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.getSize());
    }

    @Test
    public void testDeleteAt() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.deleteAt(1);
        assertEquals(2, list.getSize());
        assertFalse(list.contains(2));
    }

    @Test
    public void testDeleteAtHead() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.deleteAtHead();
        assertEquals(2, list.getSize());
        assertFalse(list.contains(1));
    }

    @Test
    public void testDeleteAtTail() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.deleteAtTail();
        assertEquals(2, list.getSize());
        assertFalse(list.contains(3));
    }

    @Test
    public void testClear() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();
        assertEquals(0, list.getSize());
    }

    @Test
    public void testContains() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(2));
        assertFalse(list.contains(4));
    }
}