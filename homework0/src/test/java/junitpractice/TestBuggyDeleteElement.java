package junitpractice;

import misc.BaseTest;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

// IntelliJ will complain that this is an unused import, but you should use them when writing your
// tests, and then the errors should go away.
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TestBuggyDeleteElement extends BaseTest {
    /**
     * In this test, you should create a new `BuggyIntList` and choose an element to delete from the
     * middle of the linked list. Your tests should check whether  the deletion is actually
     * successful by examining the linked list after attempting to delete.
     *
     * This is an example of verifying behavior for normal/"happy" cases. Our buggy implementation
     * does handle this case correctly.
     */
    @Test
    void testDeleteFromMiddle() {
        BuggyIntList myList = new BuggyIntList(new int[]{1, 2, 3, 4, 5, 6, 7}); //new BuggyIntList based on parameter
        int element = myList.get(4); //removing the 5th element
        BuggyIntList expected = new BuggyIntList(new int[]{1, 2, 3, 4, 6, 7}); //what the ideal answer should be
        myList.deleteElement(element);
        assertThat(myList.toString(), is(expected.toString())); //comparing the two results to make sure they're equal
    }

    /**
     * In this test, you should use `deleteElement` to attempt to delete the first element from a
     * linked list. Your tests should check whether the deletion is actually successful by examining
     * the linked list after attempting to delete.
     *
     * This is an example of verifying behavior for edge cases. Particularly for linked lists, front
     * cases are usually easy to miss.
     */
    @Test
    void testDeleteFromFront() {
        BuggyIntList myList = new BuggyIntList(new int[]{1, 2, 3, 4, 5, 6, 7}); //new BuggyIntList based on parameter
        int element = myList.get(0); //removing the first element
        BuggyIntList expected = new BuggyIntList(new int[]{2, 3, 4, 5, 6, 7}); //what the ideal answer should be
        myList.deleteElement(element); //what it produces after running function
        assertThat(myList, is(expected)); //comparing the two results to make sure they're equal
    }

    /**
     * The method comment of `deleteElement` claims that if you try to delete an element that is not
     * in the list, it will throw an `IllegalArgumentException`. The goal of this test is to check
     * this behavior.
     */
    @Test
    void testThrowsIllegalArgumentException() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        BuggyIntList myList = new BuggyIntList(arr); //creates new BuggyIntList based on parameter
        int element = 0; //element that's in the passed in array
        assertThrows(IllegalArgumentException.class, () -> { myList.deleteElement(element); });
    }
}