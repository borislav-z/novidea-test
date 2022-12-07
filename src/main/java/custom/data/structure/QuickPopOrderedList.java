package custom.data.structure;

import javax.management.OperationsException;

/**
 * @author ${Lyubomir Tsvetkov}
 * @brief
 *
 */

public class QuickPopOrderedList<T extends Comparable<T>> implements LinkedList<T>
{
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    // Simple push with O(1)
    @Override
    public Node<T> pop() throws OperationsException
    {
        if (head == null)
        {
            throw new OperationsException("List is empty.");
        }

        Node<T> temp = head;
        head = head.getNext();
        size--;

        return temp;
    }

    // Push that finds the greatest element and order the list on insertion so the pop can archive best case every time
    @Override
    public void push(T item)
    {
        size++;
        Node<T> newNode = new Node<>();
        newNode.setValue(item);

        // check base case scenario
        if (head == null)
        {
            head = tail = newNode;
            return;
        }

        Node<T> curr = head;

        // if first is greater than new
        if (head.getValue().compareTo(newNode.getValue()) < 0)
        {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
            return;
        }

        curr = head;

        while (!(curr.getValue().compareTo(newNode.getValue()) > 0 && (curr.getNext() == null ||
                curr.getNext().getValue().compareTo(newNode.getValue()) < 1))) {
            curr = curr.getNext();
        }

        newNode.setPrevious(curr);
        newNode.setNext(curr.getNext());

        if (curr.getNext() != null)
        {
            curr.getNext().setPrevious(newNode);
        }
        else
        {
            tail = newNode;
        }

        curr.setNext(newNode);
    }

    // return the size of the data structure
    @Override
    public int getSize()
    {
        return size;
    }
    // check if there are no elements
    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    // simple print for testing purposes
    @Override
    public void print()
    {

        Node current = head;

        // check base case if there are no elements
        if (head == null)
        {
            System.out.println("There is no data in the Linked list!");
            return;
        }
        System.out.println("Data from the Doubly linked list:");

        while (current != null)
        {
            System.out.println(current.getValue() + " ");
            current = current.getNext();
        }
    }
}