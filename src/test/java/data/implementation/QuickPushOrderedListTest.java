package data.implementation;

import data.exceptions.EmptyListException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuickPushOrderedListTest {

    @Test
    void testPopIntegers_PopulatedList_ShouldReturnThemInDescendingOrder() {
        var qPushList = new QuickPushOrderedList<Integer>();

        qPushList.push(1);
        qPushList.push(7);
        qPushList.push(4);

        assertEquals(7, qPushList.pop().getValue());
        assertEquals(4, qPushList.pop().getValue());
        assertEquals(1, qPushList.pop().getValue());
    }

    @Test
    void testPopIntegers_PopulatedList_ShouldReturnStringsInDescendingOrder() {
        var qPushList = new QuickPushOrderedList<String>();

        qPushList.push("A");
        qPushList.push("C");
        qPushList.push("B");

        assertEquals("C", qPushList.pop().getValue());
        assertEquals("B", qPushList.pop().getValue());
        assertEquals("A", qPushList.pop().getValue());
    }

    @Test
    void testPopStrings_EmptyList_ShouldFailWithEmptyListException() {
        var qPopList = new QuickPushOrderedList<String>();
        assertThatThrownBy(qPopList::pop)
                .isInstanceOf(EmptyListException.class);
    }

    //Ensure we have the expected size of the data structure
    @Test
    void testPushIntegers_PopulatedList_ShouldReturnValidSize() {
        var qPushList = new QuickPushOrderedList<Integer>();

        qPushList.push(1);
        qPushList.push(2);
        qPushList.push(3);

        assertEquals(3, qPushList.getSize());
    }

    @Test
    void testPushStrings_PopulatedList_ShouldReturnStringsInDescendingOrder() {
        var qPushList = new QuickPushOrderedList<String>();

        qPushList.push("A");
        qPushList.push("C");
        qPushList.push("B");

        assertEquals("C", qPushList.pop().getValue());
        assertEquals("B", qPushList.pop().getValue());
        assertEquals("A", qPushList.pop().getValue());
    }

    @Test
    void testPushIntegers_PopulatedList_ShouldReturnTheExactNumberOfPushedObjects() {
        var qPushList = new QuickPushOrderedList<Integer>();
        // Compare the size of the expected size and the actual size of the data structure
        for (int i = 0; i < 200; i++) {
            qPushList.push(i);
        }
        assertEquals(200, qPushList.getSize());
    }

    @Test
    void testIsEmptyListStrings_EmptyList_ShouldReturnTrue() {
        var qPushList = new QuickPushOrderedList<String>();
        assertTrue(qPushList.isEmpty());
    }
}