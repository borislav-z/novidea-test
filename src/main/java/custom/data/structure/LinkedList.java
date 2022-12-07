package custom.data.structure;

import javax.management.OperationsException;

/**
 * @author ${Lyubomir Tsvetkov}
 *
 *
 */


public interface LinkedList<T extends Comparable<T>> {
    public Node<T> pop() throws OperationsException;
    public void push(T item);
    public void print();
    public boolean isEmpty();
    public int getSize();
}
