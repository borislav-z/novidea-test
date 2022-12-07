package custom.data.structure;

import javax.management.OperationsException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ${Lyubomir Tsvetkov}
 *
 *
 */

class QuickPopOrderedListTest
{
    QuickPopOrderedList numListPop = new QuickPopOrderedList();

    @org.junit.jupiter.api.Test
    void popTestShouldBeValidInt() throws OperationsException
    {
        numListPop.push(1);
        numListPop.push(7);
        numListPop.push(4);

        assertEquals(7, numListPop.pop().getValue());
        assertEquals(4, numListPop.pop().getValue());
        assertEquals(1, numListPop.pop().getValue());
    }

    @org.junit.jupiter.api.Test
    void popTestShouldBeValidString() throws OperationsException
    {
        numListPop.push("A");
        numListPop.push("C");
        numListPop.push("B");

        assertEquals("C", numListPop.pop().getValue());
        assertEquals("B", numListPop.pop().getValue());
        assertEquals("A", numListPop.pop().getValue());
    }

    @org.junit.jupiter.api.Test
    void popTestShouldFailWithException() throws OperationsException
    {
        // It should fail and throw exception with text "List is empty"
            assertEquals(null, numListPop.pop());
    }

    //Ensure we have the expected size of the data structure
    @org.junit.jupiter.api.Test
    void pushTestShouldBeValidSizeInt()
    {
    // Test if the LinkedList push element actually push elements in the data structure by size

        numListPop.push(1);
        numListPop.push(2);
        numListPop.push(3);

        assertEquals(3, numListPop.getSize());
    }

    @org.junit.jupiter.api.Test
    void pushTestShouldBeValidInt() throws OperationsException
    {

    // Test the push method similar to pop method. It is not good practice to rely on written functionality for tests
    // However in such small project it is overkill to use mock or auxiliary classes

        numListPop.push("A");
        numListPop.push("C");
        numListPop.push("B");

        assertEquals("C", numListPop.pop().getValue());
        assertEquals("B", numListPop.pop().getValue());
        assertEquals("A", numListPop.pop().getValue());

    }

    @org.junit.jupiter.api.Test
    void getSizeTest()
    {
        // Compare the size of the expected size and the actual size of the data structure
        for(int i = 0;i < 200;i++)
        {
            numListPop.push(i);
        }
        assertEquals(200, numListPop.getSize());
    }

    @org.junit.jupiter.api.Test
    void isEmptyTest()
    {
        assertEquals(true,  numListPop.isEmpty());
    }
}