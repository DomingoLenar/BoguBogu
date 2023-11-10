/**
 * Name: Aguilar, Aaron Kyle
 * Date: October 27, 2023
 *
 * What is Queue?
 *  Queue is an object that uses the following operations:
 *      1. Enqueue(adding of an element to the end of the queue)
 *      2. Dequeue(removing of an element from the front of the queue)
 *      3. IsEmpty(checking of the queue if it is empty)
 *      4. IsFulL(checking of the queue if it is full)
 *
 *  How does queue work?
 *      1. There are two pointers which are the "front" and "back".
 *      2. The "front" tracks the first element of the queue.
 *      3. While the "back" tracks the last element of the queue.
 *
 *  How does enqueue work?
 *      1. Check first if the queue is full.
 *      2. For the first element, set the value of the "front" to 0.
 *      3. Increase the index of the back by 1.
 *      4. Add the new element in the position pointed to the "back".
 *
 *  How does dequeue work?
 *      1. Check first if the queue is empty.
 *      2. Return the value pointed by the "front".
 *      3. Increase the index of the "front" by 1.
 *      4. Reset the values of the "front" and the "back" to -1 for the last element.
 */

package Queue;
import java.util.*;

public class QueueDataStructure {
    int SIZE = 5;
    int items[] = new int[SIZE];
    int front, back;

    QueueDataStructure() {
        front = -1; //initialize the value of the front to -1
        back = -1; //initialize the value of the back to -1
    }

    public boolean isFull() {
        if (front == 0 && back == SIZE - 1) {
            return true;
        }
        return false;
    } // end of isFull method

    public boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    } // end of isEmpty method

    public void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            back++;
            items[back] = element;
            System.out.println("Inserted " + element);
        }
    } // end of enQueue method

    public int deQueue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            element = items[front];
            if (front >= back) {
                front = -1;
                back = -1;
            } /* Q has only one element, so we reset the queue after deleting it. */
            else {
                front++;
            }
            System.out.println("Deleted -> " + element);
            return (element);
        }
    } // end of deQueue method

    public void display() {
        /* Function to display elements of Queue */
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("\nFront index-> " + front);
            System.out.println("Items -> ");
            for (i = front; i <= back; i++)
                System.out.print(items[i] + "  ");

            System.out.println("\nRear index-> " + back);
        }
    } // end of display method

    public static void main(String[] args) {
        QueueDataStructure q = new QueueDataStructure();

        // deQueue is not possible on empty queue
        q.deQueue();

        // enQueue 5 elements
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // 6th element can't be added to because the queue is full
        q.enQueue(6);

        q.display();

        // deQueue removes element entered first i.e. 1
        q.deQueue();

        // Now we have just 4 elements
        q.display();

    } // end of main method

} // end of class QueueDataStructure