package custom.data.structure;

import javax.management.OperationsException;

/**
 * @author ${Lyubomir Tsvetkov}
 *
 *
 */

public class QuickPushOrderedList<T extends Comparable<T>> implements LinkedList<T>
{
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    //N/2 time complexity since we have two pointers going throughout the list searching for the biggest element
    @Override
    public Node<T> pop() throws OperationsException
    {
        //Before pop sort the linkedList or find the biggest el and pop
        if (head == null)
        {
            throw new OperationsException("List is empty.");
        }

        // find biggest
        Node<T> curr = head;
        T max = head.getValue();
        Node<T> maxElement = head;

        while (curr != null)
        {
            if (curr.getValue().compareTo(max) > 0)
            {
                max = curr.getValue();
                maxElement = curr;

            }
            curr = curr.getNext();
        }

        //Remove and return it
        if (maxElement.hasPrevious())
        {
            maxElement.getPrevious().setNext(maxElement.getNext());
        }
        else
        {
            head = maxElement.getNext();
        }

        if (maxElement.hasNext())
        {
            maxElement.getNext().setPrevious(maxElement.getPrevious());
        }
        else
        {
            tail = maxElement.getPrevious();
        }

        maxElement.setNext(null);
        maxElement.setPrevious(null);
        size--;
        return maxElement;
    }

    // Simple push with O(1)
    @Override
    public void push(T item)
    {
        Node<T> newNode = new Node<>();
        newNode.setValue(item);

        if(head == null)
        {
            head = newNode;
            tail = newNode;
            head.setPrevious(null);
            tail.setNext(null);
            size++;
        }
        else
        {
            size++;
            head.setPrevious(newNode);
            newNode.setNext(head);
            newNode.setPrevious(null);
            head = newNode;
        }
    }
    //Simple print method
    @Override
    public void print()
    {
        Node current = head;

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
    //Checking if the data structure is empty
    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    //Return the actual size of the data structure
    @Override
    public int getSize()
    {
        return size;
    }
}
