package data.implementation;

import data.contracts.LinkedItemList;
import data.contracts.ListItem;
import data.exceptions.EmptyListException;

public class QuickPopOrderedList<T extends Comparable<T>> extends LinkedItemList<T> {
    final Object syncObj = new Object();

    @Override
    public ListItem<T> pop() {
        ListItem<T> result;

        synchronized (syncObj) {
            if (isEmpty()) {
                throw new EmptyListException();
            }
            result = head;
            head = head.getNext();
            result.detach();
            decrement();
        }
        return result;
    }

    @Override
    public void push(T value) {
        var newNode = new ListItem<T>(value);

        synchronized (syncObj) {
            if (head != null) {
                newNode.setNext(head);
            }

            head = newNode;
            compareAndSwap(head, head.getNext());

            increment();
        }
    }
}
