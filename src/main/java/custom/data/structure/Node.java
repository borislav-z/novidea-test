package custom.data.structure;

/**
 * @author ${Lyubomir Tsvetkov}
 *
 * Simple Node class that contain the structure of the Node as well as some basic auxilury methods
 * such as hasNext, getValue, setValue etc.
 */

public class Node<T extends Comparable<T>>
{
    private T value;
    private Node<T> next;
    private Node<T> previous;

    public Node()
    {

    }

    public Node(T value)
    {
        this.next = null;
        this.previous = null;
        this.setValue(value);
    }

    public void setValue(T value)
    {
        this.value = value;
    }

    public void setNext(Node<T> value)
    {
        this.next = value;
    }

    public void setPrevious(Node<T> value)
    {
        this.previous = value;
    }

    public T getValue()
    {
        return this.value;
    }

    public Node<T> getNext()
    {
        return this.next;
    }

    public Node<T> getPrevious()
    {
        return this.previous;
    }

    public boolean hasNext()
    {
        return this.next != null;
    }

    public boolean hasPrevious()
    {
        return this.previous != null;
    }
}