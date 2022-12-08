package data.implementation;

import data.contracts.LinkedItemList;
import data.contracts.ListItem;
import data.exceptions.EmptyListException;

public class QuickPushOrderedList<T extends Comparable<T>> extends LinkedItemList<T> {
    @Override
    public ListItem<T> pop() {
        if (isEmpty()) {
            throw new EmptyListException();
        }

        var result = getLargest();
        result.detach();
        decrement();
        return result;
    }

    @Override
    public void push(T value) {
        var newNode = new ListItem<T>();
        newNode.setValue(value);

        newNode.setNext(head);
        head = newNode;

        increment();
    }
}
