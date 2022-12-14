package data.implementation;

import data.contracts.LinkedItemList;
import data.contracts.ListItem;
import data.exceptions.EmptyListException;

public class QuickPushOrderedList<T extends Comparable<T>> extends LinkedItemList<T> {
    final Object syncObj = new Object();

    @Override
    public ListItem<T> pop() {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        ListItem<T> result;
        synchronized (syncObj) {
            result = getLargest();
            result.detach();
            decrement();
        }
        return result;
    }

    @Override
    public void push(T value) {
        var newNode = new ListItem<T>();
        newNode.setValue(value);

        synchronized (syncObj) {
            newNode.setNext(head);
            head = newNode;

            increment();
        }
    }
}
