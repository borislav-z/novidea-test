package data.contracts;

import java.util.Objects;

public class ListItem<T extends Comparable<T>> implements Comparable<T> {
    private T value;
    private ListItem<T> next = null;

    public ListItem(){

    }

    public ListItem(T value){
        this.setValue(value);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public ListItem<T> getNext(){
        return next;
    }

    public void setNext(ListItem<T> next){
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public void detach(){
        this.next = null;
    }

    public void display(){
        System.out.println(this.value);
    }


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListItem<?> listItem = (ListItem<?>) o;
        return Objects.equals(value, listItem.value);
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }

    @Override
    public int compareTo(T o){
        return value.compareTo(o);
    }
}