package data.implementation;

import org.junit.jupiter.api.Test;

import javax.management.OperationsException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickPushOrderedListTest {


    @Test
    void popTestShouldBeValidInt() throws OperationsException
    {
        var qPushList = new QuickPopOrderedList();

        qPushList.push(1);
        qPushList.push(7);
        qPushList.push(4);

        assertEquals(7, qPushList.pop().getValue());
        assertEquals(4, qPushList.pop().getValue());
        assertEquals(1, qPushList.pop().getValue());
    }

    @Test
    void popTestShouldBeValidString() throws OperationsException
    {
        var qPushList = new QuickPopOrderedList();

        qPushList.push("A");
        qPushList.push("C");
        qPushList.push("B");

        assertEquals("C", qPushList.pop().getValue());
        assertEquals("B", qPushList.pop().getValue());
        assertEquals("A", qPushList.pop().getValue());
    }

    @Test
    void popTestShouldFailWithException() throws OperationsException
    {
        var qPushList = new QuickPopOrderedList();

        // It should fail and throw exception with text "List is empty"
        assertEquals(null, qPushList.pop());
    }

    //Ensure we have the expected size of the data structure
    @Test
    void pushTestShouldBeValidSizeInt()
    {
        // Test if the LinkedList push element actually push elements in the data structure by size

        var qPushList = new QuickPopOrderedList();

        qPushList.push(1);
        qPushList.push(2);
        qPushList.push(3);

        assertEquals(3, qPushList.getSize());
    }

    @Test
    void pushTestShouldBeValidInt() throws OperationsException
    {

        // Test the push method similar to pop method. It is not good practice to rely on written functionality for tests
        // However in such small project it is overkill to use mock or auxiliary classes
        var qPushList = new QuickPopOrderedList();

        qPushList.push("A");
        qPushList.push("C");
        qPushList.push("B");

        assertEquals("C", qPushList.pop().getValue());
        assertEquals("B", qPushList.pop().getValue());
        assertEquals("A", qPushList.pop().getValue());

    }

    @Test
    void getSizeTest()
    {
        var qPushList = new QuickPopOrderedList();

        // Compare the size of the expected size and the actual size of the data structure
        for(int i = 0;i < 200;i++)
        {
            qPushList.push(i);
        }
        assertEquals(200, qPushList.getSize());
    }

    @Test
    void isEmptyTest(){
        var qPushList = new QuickPopOrderedList();
        assertEquals(true,  qPushList.isEmpty());
    }
}