package data.implementation;

import javax.management.OperationsException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuickPopOrderedListTest
{
    @org.junit.jupiter.api.Test
    void popTestShouldBeValidInt() throws OperationsException
    {
        var qPopList = new QuickPopOrderedList();

        qPopList.push(1);
        qPopList.push(7);
        qPopList.push(4);

        assertEquals(7, qPopList.pop().getValue());
        assertEquals(4, qPopList.pop().getValue());
        assertEquals(1, qPopList.pop().getValue());
    }

    @org.junit.jupiter.api.Test
    void popTestShouldBeValidString() throws OperationsException
    {
        var qPopList = new QuickPopOrderedList();

        qPopList.push("A");
        qPopList.push("C");
        qPopList.push("B");

        assertEquals("C", qPopList.pop().getValue());
        assertEquals("B", qPopList.pop().getValue());
        assertEquals("A", qPopList.pop().getValue());
    }

    @org.junit.jupiter.api.Test
    void popTestShouldFailWithException() throws OperationsException
    {
        var qPopList = new QuickPopOrderedList();
        // It should fail and throw exception with text "List is empty"
        assertThrows(OperationsException.class, () ->{qPopList.pop();});
    }

    //Ensure we have the expected size of the data structure
    @org.junit.jupiter.api.Test
    void pushTestShouldBeValidSizeInt()
    {
        // Test if the LinkedList push element actually push elements in the data structure by size
        var qPopList = new QuickPopOrderedList();

        qPopList.push(1);
        qPopList.push(2);
        qPopList.push(3);

        assertEquals(3, qPopList.getSize());
    }

    @org.junit.jupiter.api.Test
    void pushTestShouldBeValidInt() throws OperationsException
    {
        var qPopList = new QuickPopOrderedList();

        qPopList.push("A");
        qPopList.push("C");
        qPopList.push("B");

        assertEquals("C", qPopList.pop().getValue());
        assertEquals("B", qPopList.pop().getValue());
        assertEquals("A", qPopList.pop().getValue());

    }

    @org.junit.jupiter.api.Test
    void getSizeTest()
    {
        var qPopList = new QuickPopOrderedList();
        // Compare the size of the expected size and the actual size of the data structure
        for(int i = 0;i < 200;i++)
        {
            qPopList.push(i);
        }
        assertEquals(200, qPopList.getSize());
    }

    @org.junit.jupiter.api.Test
    void isEmptyTest(){
        var qPopList = new QuickPopOrderedList();
        assertEquals(true,  qPopList.isEmpty());
    }
}