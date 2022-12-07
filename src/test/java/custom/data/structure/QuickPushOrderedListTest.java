package custom.data.structure;

import org.junit.jupiter.api.Test;

import javax.management.OperationsException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ${Lyubomir Tsvetkov}
 *
 *
 */

class QuickPushOrderedListTest {

    QuickPushOrderedList numListPush = new QuickPushOrderedList();

    @Test
    void popTestShouldBeValidInt() throws OperationsException
    {
        numListPush.push(1);
        numListPush.push(7);
        numListPush.push(4);

        assertEquals(7, numListPush.pop().getValue());
        assertEquals(4, numListPush.pop().getValue());
        assertEquals(1, numListPush.pop().getValue());
    }

    @Test
    void popTestShouldBeValidString() throws OperationsException
    {
        numListPush.push("A");
        numListPush.push("C");
        numListPush.push("B");

        assertEquals("C", numListPush.pop().getValue());
        assertEquals("B", numListPush.pop().getValue());
        assertEquals("A", numListPush.pop().getValue());
    }

    @Test
    void popTestShouldFailWithException() throws OperationsException
    {
        // It should fail and throw exception with text "List is empty"
        assertEquals(null, numListPush.pop());
    }

    //Ensure we have the expected size of the data structure
    @Test
    void pushTestShouldBeValidSizeInt()
    {
        // Test if the LinkedList push element actually push elements in the data structure by size

        numListPush.push(1);
        numListPush.push(2);
        numListPush.push(3);

        assertEquals(3, numListPush.getSize());
    }

    @Test
    void pushTestShouldBeValidInt() throws OperationsException
    {

        // Test the push method similar to pop method. It is not good practice to rely on written functionality for tests
        // However in such small project it is overkill to use mock or auxiliary classes

        numListPush.push("A");
        numListPush.push("C");
        numListPush.push("B");

        assertEquals("C", numListPush.pop().getValue());
        assertEquals("B", numListPush.pop().getValue());
        assertEquals("A", numListPush.pop().getValue());

    }

    @Test
    void getSizeTest()
    {
        // Compare the size of the expected size and the actual size of the data structure
        for(int i = 0;i < 200;i++)
        {
            numListPush.push(i);
        }
        assertEquals(200, numListPush.getSize());
    }

    @Test
    void isEmptyTest()
    {
        assertEquals(true,  numListPush.isEmpty());
    }
}