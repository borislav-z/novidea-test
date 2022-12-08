package data.implementation;

import data.contracts.LinkedItemList;
import data.contracts.ListItem;

import javax.management.OperationsException;
import java.util.Comparator;

public class QuickPopOrderedList<T extends Comparable<T>, C extends Comparator<T>> extends LinkedItemList<T, C> {
    @Override
    public ListItem<T> pop() throws OperationsException {
        if (isEmpty()) {
            throw new OperationsException("List is empty.");
        }

        var result = head;
        head = head.getNext();
        result.detach();
        decrement();

        return result;
    }

    @Override
    public void push(T value) {
        var newNode = new ListItem<T>();
        newNode.setValue(value);

        if(head != null){
            newNode.setNext(head);
        }
        head = newNode;
        compareAndSwap(head, head.getNext());

        increment();
    }
}
