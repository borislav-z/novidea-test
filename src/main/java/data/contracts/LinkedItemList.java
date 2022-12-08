package data.contracts;

import java.util.Comparator;

public abstract class LinkedItemList<
        T extends Comparable<T>,
        C extends Comparator<T>> implements ILinkedItemList<T, C> {

    protected ListItem<T> head = null;
    private C comparator = null;
    private int size = 0;

    @Override
    public int getSize() {
        return size;
    }

    // check if there are no elements
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void setComparator(C comparator) {
        this.comparator = comparator;
    }

    // recursively displays the elements of the list one by one
    @Override
    public void display() {
        // check base case if there are no elements
        if (isEmpty()) {
            System.out.println("No data!");
            return;
        }

        display(head);
    }

    //Recursively finds the right place for the new items (keeps the list sorted)
    protected void compareAndSwap(ListItem<T> item1, ListItem<T> item2){
        if((compare(item1, item2) >= 0)){
            return;
        }

        var tmp = item1.getValue();
        item1.setValue(item2.getValue());
        item2.setValue(tmp);

        if(item2.hasNext()){
            compareAndSwap(item2, item2.getNext());
        }
    }

    //Finds the largest element (using the compare method with ot without custom comparator)
    protected ListItem<T> getLargest(){
        var result = head;
        var prev = head;
        var cur = head;

        while(cur.hasNext()){
            if(compare(result, cur.getNext()) < 0){
                prev = cur;
                result = cur.getNext();
            }
            cur = cur.getNext();
        }

        prev.setNext(result.getNext());
        if(result == head){
            head = result.getNext();
        }
        return result;
    }

    protected void increment(){
        size++;
    }

    protected void decrement(){
        size--;
        if(size == 0){
            head = null;
        }
    }

    private void display(ListItem<T> item){
        item.display();
        if(item.hasNext()){
            display(item.getNext());
        }
    }

    private int compare(ListItem<T> item1, ListItem<T> item2) {
        if(item1 == null){
            return -1;
        } else if(item2 == null){
            return 1;
        }else if (comparator != null) {
            return comparator.compare(item1.getValue(), item2.getValue());
        } else {
            return item1.getValue().compareTo(item2.getValue());
        }
    }
}
