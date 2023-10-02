package testcases;
import static org.junit.Assert.*;
import datastruc.SingleLinkedList;
import org.junit.Before;
import org.junit.Test;

public class SingleLinkedListTest {

    public SingleLinkedList<Integer> list;

    // This method runs before each test case to set up a fresh instance of SingleLinkedList
    @Before
    public void setUp() {
        list = new SingleLinkedList<>();
    }


    // Test case for the 'add' method
    @Test
    public void testAdd() {
        list.add(1);
        list.add(2);
        list.add(3);


        // Check if the size of the list is as expected
        assertEquals(3, list.getSize());
    }


    // Test case for the 'deleteAt' method
    @Test
    public void testDeleteAt() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.deleteAt(1);

        // Check if the size is reduced and the deleted element is not in the list
        assertEquals(2, list.getSize());
        assertFalse(list.contains(2));
    }


    // Test case for the 'deleteAtHead' method
    @Test
    public void testDeleteAtHead() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.deleteAtHead();

        // Check if the size is reduced and the head element is removed
        assertEquals(2, list.getSize());
        assertFalse(list.contains(1));
    }


    // Test case for the 'deleteAtTail' method
    @Test
    public void testDeleteAtTail() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.deleteAtTail();

        // Check if the size is reduced and the tail element is removed
        assertEquals(2, list.getSize());
        assertFalse(list.contains(3));
    }

    // Test case for the 'clear' method
    @Test
    public void testClear() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();

        // Check if the list is cleared and the size becomes 0
        assertEquals(0, list.getSize());
    }


    // Test case for the 'contains' method
    @Test
    public void testContains() {
        list.add(1);
        list.add(2);
        list.add(3);


        // Check if the 'contains' method correctly identifies elements in the list
        assertTrue(list.contains(2));
        assertFalse(list.contains(4));
    }
}  // End of SingleLinkedListTest class