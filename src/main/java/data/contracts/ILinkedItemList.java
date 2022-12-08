package data.contracts;

import javax.management.OperationsException;
import java.util.Comparator;

public interface ILinkedItemList<
        T extends Comparable<T>,
        C extends Comparator<T>> {

    //Returns the last element of the list
    ListItem<T> pop() throws OperationsException;

    //Insert an element in the list
    void push(T value);

    //Returns the size of the list
    int getSize();

    // check if there are no elements
    boolean isEmpty();

    //Set custom comparator if necessary
    void setComparator(C comparator);

    // simple print for testing purposes
    void display();
}
