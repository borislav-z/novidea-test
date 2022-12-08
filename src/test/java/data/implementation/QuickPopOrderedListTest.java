package data.implementation;

import data.exceptions.EmptyListException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuickPopOrderedListTest {

    @Test
    void testPopIntegers_PopulatedList_ShouldReturnThemInDescendingOrder() {
        var qPopList = new QuickPopOrderedList<Integer>();

        qPopList.push(1);
        qPopList.push(7);
        qPopList.push(4);

        assertEquals(7, qPopList.pop().getValue());
        assertEquals(4, qPopList.pop().getValue());
        assertEquals(1, qPopList.pop().getValue());
    }

    @Test
    void testPopIntegers_PopulatedList_ShouldReturnStringsInDescendingOrder() {
        var qPopList = new QuickPopOrderedList<String>();

        qPopList.push("A");
        qPopList.push("C");
        qPopList.push("B");

        assertEquals("C", qPopList.pop().getValue());
        assertEquals("B", qPopList.pop().getValue());
        assertEquals("A", qPopList.pop().getValue());
    }

    @Test
    void testPopStrings_EmptyList_ShouldFailWithEmptyListException() {
        var qPopList = new QuickPopOrderedList<String>();
        assertThatThrownBy(qPopList::pop)
                .isInstanceOf(EmptyListException.class);
    }

    //Ensure we have the expected size of the data structure
    @Test
    void testPushIntegers_PopulatedList_ShouldReturnValidSize() {
        var qPopList = new QuickPopOrderedList<Integer>();

        qPopList.push(1);
        qPopList.push(2);
        qPopList.push(3);

        assertEquals(3, qPopList.getSize());
    }

    @Test
    void testPushStrings_PopulatedList_ShouldReturnStringsInDescendingOrder() {
        var qPopList = new QuickPopOrderedList<String>();

        qPopList.push("A");
        qPopList.push("C");
        qPopList.push("B");

        assertEquals("C", qPopList.pop().getValue());
        assertEquals("B", qPopList.pop().getValue());
        assertEquals("A", qPopList.pop().getValue());
    }

    @Test
    void testPushIntegers_PopulatedList_ShouldReturnTheExactNumberOfPushedObjects() {
        var qPopList = new QuickPopOrderedList<Integer>();
        // Compare the size of the expected size and the actual size of the data structure
        for (int i = 0; i < 200; i++) {
            qPopList.push(i);
        }
        assertEquals(200, qPopList.getSize());
    }

    @Test
    void testIsEmptyListStrings_EmptyList_ShouldReturnTrue() {
        var qPopList = new QuickPopOrderedList<String>();
        assertTrue(qPopList.isEmpty());
    }
}