package datastructures.priorityqueues;

import datastructures.EmptyContainerException;
import datastructures.dictionaries.IDictionary;
import misc.BaseTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * See spec for details on what kinds of tests this class should include.
 */
@Tag("project3")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TestArrayHeapPriorityQueue extends BaseTest {
    protected <T extends Comparable<T>> IPriorityQueue<T> makeInstance() {
        return new ArrayHeapPriorityQueue<>();
    }

    /**
     * A helper method for accessing the private array inside an `ArrayHeapPriorityQueue`.
     */
    protected static <T extends Comparable<T>> Comparable<T>[] getArray(IPriorityQueue<T> heap) {
        return ((ArrayHeapPriorityQueue<T>) heap).heap;
    }

    protected static <T extends Comparable<T>> IDictionary<T, Integer> getDictionary(IPriorityQueue<T> heap) {
        return ((ArrayHeapPriorityQueue<T>) heap).indices;
    }

    @Test
    void testAddEmptyInternalArray() {
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(3);
        Comparable<Integer>[] array = getArray(heap);
        assertThat(array[0], is(3));
    }

    @Test
    void testUpdateDecrease() {
        IPriorityQueue<IntPair> heap = this.makeInstance();
        for (int i = 1; i <= 5; i++) {
            heap.add(new IntPair(i, i));
        }

        heap.replace(new IntPair(2, 2), new IntPair(0, 0));

        assertThat(heap.removeMin(), is(new IntPair(0, 0)));
        assertThat(heap.removeMin(), is(new IntPair(1, 1)));
    }

    @Test
    void testUpdateIncrease() {
        IntPair[] values = IntPair.createArray(new int[][]{{0, 0}, {2, 2}, {4, 4}, {6, 6}, {8, 8}});
        IPriorityQueue<IntPair> heap = this.makeInstance();

        for (IntPair value : values) {
            heap.add(value);
        }

        IntPair newValue = new IntPair(5, 5);
        heap.replace(values[0], newValue);

        assertThat(heap.removeMin(), is(values[1]));
        assertThat(heap.removeMin(), is(values[2]));
        assertThat(heap.removeMin(), is(newValue));
    }

    @Test
    void testBasicHeap() { // Tests making a basic heap of ints and checks basic size
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);
        Comparable<Integer>[] array = getArray(heap);
        assertThat(array[0], is(3));
        assertThat(array[1], is(4));
        assertThat(array[2], is(5));
        assertThat(array[3], is(6));
        assertThat(array[4], is(7));
        assertThat(array[5], is(8));
        assertThat(heap.size(), is(6)); // checks size
    }

    @Test
    void testOutOfOrderHeap() { // Tests making a basic heap of ints and checks basic size out of order
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(7);
        heap.add(4);
        heap.add(5);
        heap.add(10);
        heap.add(3);
        heap.add(2);
        Comparable<Integer>[] array = getArray(heap);
        assertThat(array[0], is(2));
        assertThat(array[1], is(3));
        assertThat(array[2], is(5));
        assertThat(array[3], is(10));
        assertThat(array[4], is(4));
        assertThat(array[5], is(7));
        assertThat(heap.size(), is(6)); // checks size
    }

    @Test
    void testDuplicateElements() { // Should throw invalidElementException if duplicate elements are inserted
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(1);
        heap.add(2);
        assertThrows(InvalidElementException.class, () -> { heap.add(1); });
    }

    @Test
    void testPeekAndRemoveOneElement() { // tests peek and removingMin for one element
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(2);

        assertThat(heap.peekMin(), is(2)); // checks size

        heap.removeMin();

        assertThat(heap.size(), is(0));
    }

    @Test
    void testRemoveMinEmpty() { // Tests that removeMin called on an empty queue throws exception
        IPriorityQueue<Integer> heap = this.makeInstance();
        assertThat(heap.size(), is(0));
        assertThrows(EmptyContainerException.class, () -> { heap.removeMin(); });
    }

    @Test
    void testPeekMinEmpty() { // test peekMin on empty queue
        IPriorityQueue<Integer> heap = this.makeInstance();
        assertThat(heap.size(), is(0));
        assertThrows(EmptyContainerException.class, () -> { heap.peekMin(); });
    }

    @Test
    void testAddEmpty() { // adds one element to empty queue
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(1);
        assertThat(heap.size(), is(1));
    }

    @Test
    void testAddNull() { // throws IllegalArgumentException
        IPriorityQueue<String> heap = this.makeInstance();
        heap.add("aa");
        heap.add("ue");
        assertThrows(IllegalArgumentException.class, () -> { heap.add(null); });
    }

    @Test
    void testAddArrayState() {
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(3);
        heap.add(4);
        heap.add(2);
        heap.add(5);
        Comparable<Integer>[] array = getArray(heap);
        assertThat(array[0], is(2));
        assertThat(array[1], is(4));
        assertThat(array[2], is(3));
        assertThat(array[3], is(5));
    }

    @Test
    void testContainsEmpty() { // should be false
        IPriorityQueue<String> heap = this.makeInstance();
        assertThat(heap.contains("aa"), is(false));
    }

    @Test
    void testContainsNull() { // tests contains null throws exception
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(2);
        heap.add(5);
        assertThrows(IllegalArgumentException.class, () -> { heap.contains(null); });
    }

    @Test
    void testRemoveMinTwo() { //tests peek and removingMin for two elements
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(2);
        heap.add(3);

        assertThat(heap.peekMin(), is(2)); //checks size

        heap.removeMin();

        assertThat(heap.peekMin(), is(3));

        heap.removeMin();

        assertThat(heap.size(), is(0));
    }

    @Test
    void testRemoveMinBasic() { // Remove min with percolate down
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(3);
        heap.add(5);
        heap.add(6);

        assertThat(heap.peekMin(), is(3));
        heap.removeMin();
        assertThat(heap.peekMin(), is(5));
        heap.removeMin();
        assertThat(heap.peekMin(), is(6));
        heap.removeMin();
        assertThat(heap.size(), is(0));
    }

    @Test
    void testRemoveMinHeapInvariant() {
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(1);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        Comparable<Integer>[] array = getArray(heap);

        assertThat(array[0], is(1));
        assertThat(array[1], is(3));
        assertThat(array[2], is(4));
        assertThat(array[3], is(5));

        heap.removeMin();

        assertThat(array[0], is(3));
        assertThat(array[1], is(5));
        assertThat(array[2], is(4));
    }

    @Test
    void testRemoveMinOneChild() {
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(1);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        Comparable<Integer>[] array = getArray(heap);

        heap.removeMin();

        assertThat(array[0], is(3));
        assertThat(array[1], is(7));
    }
    @Test
    void testRemoveMinMultipleElements() { //need to fix percolate down to make sure this works
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(2); //min

        assertThat(heap.peekMin(), is(2)); //min

        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);

        assertThat(heap.size(), is(7));
        assertThat(heap.peekMin(), is(2)); //should still be 2

        heap.removeMin(); //should remove 2 still

        assertThat(heap.size(), is(6));

        heap.add(1); //new min

        assertThat(heap.peekMin(), is(1)); //should be 1 now

        heap.removeMin(); //should remove 1 instead

        assertThat(heap.size(), is(6));

        heap.add(0); //new min

        assertThat(heap.peekMin(), is(0)); //should be 0 now

        heap.removeMin(); //should remove 0 instead

        assertThat(heap.size(), is(6));
    }

    @Test
    void testRemoveMinBreakTie() {
        IPriorityQueue<IntPair> heap = this.makeInstance();
        heap.add(new IntPair(1, 1));
        heap.add(new IntPair(2, 3));
        heap.add(new IntPair(1, 4));

        assertThat(heap.size(), is(3));
        heap.removeMin();
        heap.removeMin();
        heap.removeMin();
        assertThat(heap.size(), is(0));
    }

    @Test
    void testRemoveEmpty() { // trying to remove something from an empty queue should always throw exception
        IPriorityQueue<String> heap = this.makeInstance();
        assertThrows(InvalidElementException.class, () -> { heap.remove("aa"); });
    }

    @Test
    void testRemoveElementNotInQueue() {
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(4);
        assertThrows(InvalidElementException.class, () -> {heap.remove(5); });
    }

    @Test
    void testRemoveSingleElement() {
        IPriorityQueue<String> heap = this.makeInstance();
        heap.add("t");
        heap.remove("t");
        assertThat(heap.isEmpty(), is(true));
    }

    @Test
    void testRemoveTwoElements() {
        IPriorityQueue<String> heap = this.makeInstance();
        heap.add("a");
        heap.add("b");
        heap.remove("a");
        assertThat(heap.peekMin(), is("b"));
    }

    @Test
    void testRemoveBasic() {
        IPriorityQueue<String> heap = this.makeInstance();
        heap.add("a");
        heap.add("b");
        heap.add("c");
        heap.add("d");

        heap.remove("b");

        assertThat(heap.size(), is(3));
        assertThat(heap.peekMin(), is("a"));

        Comparable<String>[] array = getArray(heap);
        assertThat(array[3], is(nullValue()));
    }
    @Test
    void testRemoveLastItem() { //no need for any percolations just remove and replacing numbers
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(2); //min

        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);
        Comparable<Integer>[] array = getArray(heap);

        heap.remove(8);

        assertThat(array[0], is(2));
        assertThat(array[1], is(3));
        assertThat(array[2], is(4));
        assertThat(array[3], is(5));
        assertThat(array[4], is(6));
        assertThat(array[5], is(7));
        assertThat(array[6], is(nullValue()));

        assertThat(heap.size(), is(6));
    }

    @Test
    void testRemoveItemPercolateDown() {
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(2); //min

        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);
        Comparable<Integer>[] array = getArray(heap);

        heap.remove(3);

        assertThat(array[0], is(2));
        assertThat(array[1], is(7));
        assertThat(array[2], is(4));
        assertThat(array[3], is(5));
        assertThat(array[4], is(6));
        assertThat(array[5], is(8));
        assertThat(array[6], is(nullValue()));

        assertThat(heap.size(), is(6));
    }

    @Test
    void testReplaceNull() {
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(3);
        heap.add(4);
        assertThrows(IllegalArgumentException.class, () -> {heap.replace(3, null); });
        assertThrows(IllegalArgumentException.class, () -> {heap.replace(null, 3); });
    }

    @Test
    void testReplaceInvalidElement() {
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(3);
        heap.add(4);
        assertThrows(InvalidElementException.class, () -> {heap.replace(4, 3); });
        assertThrows(InvalidElementException.class, () -> {heap.replace(2, 5); });
    }

    @Test
    void testReplaceSingleElement() {
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(3);
        assertThat(heap.peekMin(), is(3));
        heap.replace(3, 5);
        assertThat(heap.peekMin(), is(5));
    }

    @Test
    void testReplaceBasic() {
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(5);
        heap.add(7);
        heap.add(8);
        heap.add(9);
        heap.replace(9, 2);
        assertThat(heap.peekMin(), is(2));
    }

    @Test
    void testReplacePercolateDown() {
        IPriorityQueue<String> heap = this.makeInstance();
        heap.add("a");
        heap.add("b");
        heap.add("c");
        heap.add("d");
        heap.replace("a", "z");
        assertThat(heap.peekMin(), is("b"));
        IDictionary<String, Integer> dict = getDictionary(heap);
        assertThat(dict.size(), is(4));
        assertThat(dict.containsKey("a"), is(false));
        assertThat(dict.containsKey("z"), is(true));
    }
    @Test
    void testReplaceWithPercolationUpwards() { //upwards percolation needed
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(2); //min

        assertThat(heap.peekMin(), is(2)); //min

        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);
        heap.add(7);
        heap.add(8);
        Comparable<Integer>[] array = getArray(heap);

        assertThat(heap.size(), is(7));
        assertThat(heap.peekMin(), is(2)); //should still be 2

        heap.replace(8, 0);

        assertThat(array[0], is(0));
        assertThat(array[1], is(2));
        assertThat(array[2], is(4));
        assertThat(array[3], is(5));
        assertThat(array[4], is(6));
        assertThat(array[5], is(7));
        assertThat(array[6], is(3));

        assertThat(heap.size(), is(7));
    }

    @Test
    void testReplaceWithPercolationDownwards() { //downwards percolation needed
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(2); //min

        assertThat(heap.peekMin(), is(2)); //min

        heap.add(4);
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(8);
        heap.add(9);
        heap.add(6);
        heap.add(10);
        Comparable<Integer>[] array = getArray(heap);

        assertThat(heap.size(), is(9));
        assertThat(heap.peekMin(), is(2)); //should still be 2

        heap.replace(2, 22); //will need to percolate down

        assertThat(array[0], is(3));
        assertThat(array[1], is(4));
        assertThat(array[2], is(5));
        assertThat(array[3], is(22));
        assertThat(array[4], is(7));
        assertThat(array[5], is(8));
        assertThat(array[6], is(9));
        assertThat(array[7], is(6));
        assertThat(array[8], is(10));
    }
    @Test
    void testAllExceptions() { //tests removeMin for many elements in heap
        IPriorityQueue<Integer> heap = this.makeInstance();
        heap.add(2); //min

        assertThat(heap.peekMin(), is(2)); //min
        assertThrows(InvalidElementException.class, () -> { heap.add(2); });
        assertThrows(IllegalArgumentException.class, () -> { heap.add(null); });

        heap.removeMin(); //removes 2 with nothing left in heap
        assertThat(heap.size(), is(0));
        assertThrows(EmptyContainerException.class, () -> { heap.removeMin(); });
        assertThrows(EmptyContainerException.class, () -> { heap.peekMin(); });
        assertThrows(IllegalArgumentException.class, () -> { heap.contains(null); });
        assertThrows(IllegalArgumentException.class, () -> { heap.remove(null); });

        heap.add(3);

        assertThat(heap.size(), is(1));
        assertThrows(InvalidElementException.class, () -> { heap.remove(4); }); //not in heap yet
        assertThrows(IllegalArgumentException.class, () -> { heap.replace(null, 5); });
        assertThrows(IllegalArgumentException.class, () -> { heap.replace(8, null); });

        heap.add(5);
        heap.add(2);
        assertThat(heap.size(), is(3));
        assertThrows(InvalidElementException.class, () -> { heap.replace(2, 3); }); //already in q
        assertThrows(InvalidElementException.class, () -> { heap.replace(7, 3); }); //not in queue

        heap.add(4);
        heap.add(-6);
        heap.add(7);
        heap.add(8);

        assertThat(heap.size(), is(7));
        assertThat(heap.peekMin(), is(-6)); //shouldbe -6 TESTS NEGATIVES

        heap.removeMin(); //should remove -6

        assertThat(heap.size(), is(6));

        heap.add(1); //new min

        assertThat(heap.peekMin(), is(1)); //should be 1 now
    }
}