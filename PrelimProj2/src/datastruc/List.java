/**
 * September 20, 2023
 */
package datastruc;

public interface List <T>{
    void add(T data);
    void deleteAt (int index);
    void deleteAtHead();
    void deleteAtTail();//
    void clear();
    int getSize();
    boolean contains(T data);
}//end of interface
