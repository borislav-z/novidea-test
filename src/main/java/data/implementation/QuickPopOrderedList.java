package data.implementation;

import data.contracts.LinkedItemList;
import data.contracts.ListItem;
import data.exceptions.EmptyListException;

public class QuickPopOrderedList<T extends Comparable<T>> extends LinkedItemList<T> {

    @Override
    public synchronized ListItem<T> pop() {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        var result = head;
        head = head.getNext();
        result.detach();
        decrement();

        return result;
    }

    @Override
    public synchronized void push(T value) {
        var newNode = new ListItem<T>(value);

        if (head != null) {
            newNode.setNext(head);
        }

        head = newNode;
        compareAndSwap(head, head.getNext());

        increment();
    }
}
