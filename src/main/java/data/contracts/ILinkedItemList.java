package data.contracts;

import java.util.Comparator;

public interface ILinkedItemList<T extends Comparable<T>> {

    /**
     * Returns the last element of the list
     */
    ListItem<T> pop();

    /**
     * Insert an element in the list
     */
    void push(T value);

    /**
     * Returns the size of the list
     */
    int getSize();

    /**
     * check if there are no elements
     */
    boolean isEmpty();

    /**
     * Set custom comparator if necessary
     */
    void setComparator(Comparator<T> comparator);

    /**
     * Displays recursively each element's value from the list
     */
    void display();
}
