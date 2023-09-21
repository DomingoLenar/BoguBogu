/**
 * September 20, 2023
 */
package datastruc;

public interface List <T>{
    void add();
    void insert (T element, int index);
    void deleteAt (int index);
    void deleteAtHead();
    void deleteAtTail();//
    void clear();
    boolean contains();
    int size();
}//End of interface
