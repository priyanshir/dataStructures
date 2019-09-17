package datastructures.priorityqueues;

import datastructures.EmptyContainerException;
import datastructures.dictionaries.ChainedHashDictionary;
import datastructures.dictionaries.IDictionary;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @see IPriorityQueue for details on what each method must do.
 */
public class ArrayHeapPriorityQueue<T extends Comparable<T>> implements IPriorityQueue<T> {
    // See spec: you must implement a 4-heap.
    private static final int NUM_CHILDREN = 4;

    /*
    You MUST use this field to store the contents of your heap.
    You may NOT rename this field or change its type: we will be inspecting it in our secret tests.
    */
    T[] heap;
    IDictionary<T, Integer> indices;

    // Feel free to add more fields and constants.
    private static final int INITIAL_ARRAY_CAPACITY = 10;

    public ArrayHeapPriorityQueue() {
        this.heap = makeArrayOfT(INITIAL_ARRAY_CAPACITY); // Initialize heap array
        this.indices = new ChainedHashDictionary<T, Integer>(); // Initialize index dictionary
    }

    /**
     * This method will return a new, empty array of the given size
     * that can contain elements of type `T`.
     *
     * Note that each element in the array will initially be null.
     */
    @SuppressWarnings("unchecked")
    private T[] makeArrayOfT(int arraySize) {
        /*
        This helper method is basically the same one we gave you in `ArrayDictionary` and
        `ChainedHashDictionary`.

        As before, you do not need to understand how this method works, and should not modify it in
         any way.
        */
        return (T[]) (new Comparable[arraySize]);
    }

    @Override
    public T removeMin() {

        if (this.isEmpty()) {
            throw new EmptyContainerException();
        }

        T element = this.peekMin(); // save smallest element

        if (this.indices.size() == 1) { // If there is only one element
            this.heap[0] = null;
            this.indices.remove(element);
            return element;
        }
        if (this.indices.size() == 2) { //If there are two elements
            this.heap[0] = this.heap[1];
            this.indices.remove(element);
            this.heap[1] = null;
            return element;
        }

        this.heap[0] = this.heap[this.indices.size() - 1]; // put last element first
        this.heap[this.indices.size() - 1] = null; // Get rid of last element copy
        this.indices.remove(element);

        percolate(0, this.heap[0]);

        return element;
    }

    @Override
    public T peekMin() {
        if (this.isEmpty()) {
            throw new EmptyContainerException();
        }
        return this.heap[0];
    }

    @Override
    public void add(T item) {

        if (item == null) { // Trying to add null element: throw exception
            throw new IllegalArgumentException();
        }
        if (this.contains(item)) { // Queue already has this item: throw exception
            throw new InvalidElementException();
        }

        // Item is valid
        if (this.isEmpty()) { // If heap is empty, item becomes the root
            this.heap[0] = item;
            this.indices.put(item, 0);
        } else { // If heap is not empty
            if (this.indices.size() == this.heap.length - 1) { // If need to resize
                this.heap = Arrays.copyOf(this.heap, this.heap.length * 2);
            }
            // Otherwise, add to end and percolate up
            this.heap[this.indices.size()] = item; // Add item to the end
            percolate(this.indices.size(), item);
        }
    }

    @Override
    public boolean contains(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        return indices.containsKey(item);
    }

    @Override
    public void remove(T item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (!this.contains(item)) {
            throw new InvalidElementException();
        }

        if (this.size() == 1) { // If there is a single element, just remove it
            this.heap[0] = null;
        } else if (this.size() == 2) { // Two elements
            if (this.heap[0] == item) { // If it's the root
                this.heap[0] = this.heap[1];
            }
            this.heap[1] = null;
        } else {
            int index = this.indices.get(item);
            if (index == this.indices.size() - 1) { // If the item is the last in the heap, just remove it
                this.heap[index] = null;
            } else { // If it's elsewhere in the heap
                swap(index, this.indices.size() - 1); // Swap with last element
                this.heap[this.indices.size() - 1] = null; // Get rid of it
                percolate(index, this.heap[index]); // Get the swapped element to the right spot
            }
        }
        this.indices.remove(item);
    }

    @Override
    public void replace(T oldItem, T newItem) {
        if (oldItem == null || newItem == null) {
            throw new IllegalArgumentException();
        }
        if (!this.contains(oldItem) || this.contains(newItem)) {
            throw new InvalidElementException();
        }

        int index = this.indices.remove(oldItem); // Update dictionary
        this.heap[index] = newItem;
        this.indices.put(newItem, index);

        percolate(index, newItem);
    }

    @Override
    public int size() {
        return indices.size();
    }

    /**
     * A method stub that you may replace with a helper method for percolating
     * upwards from a given index, if necessary.
     */
    private void percolateUp(int index, T item) {
        if (index > 0) { // If the element is not at the root
            int parentIndex = getParentIndex(index);
            swap(index, parentIndex);
            percolate(parentIndex, item);
        }
    }

    /**
     * A method stub that you may replace with a helper method for percolating
     * downwards from a given index, if necessary.
     */
    private void percolateDown(int index, T item) {
        if (!isALeaf(index) && needsToPercolateDown(index)) {
            T minItem = this.heap[getChild(index, 1)]; //If not a leaf, guaranteed to have at least left child
            for (int i = 2; i < 5; i++) {
                int child = getChild(index, i);
                if (child < this.heap.length && this.heap[child] != null) { // Make sure child index is within array
                    if (minItem.compareTo(this.heap[child]) > 0) { // If it's smaller than current min item, update
                        minItem = this.heap[child];
                    }
                }
            }
            int minChildIndex = this.indices.get(minItem); // Index of child in array
            swap(index, minChildIndex);
            percolate(minChildIndex, item);
        }
    }

    /**
     * A method stub that you may replace with a helper method for determining
     * which direction an index needs to percolate and percolating accordingly.
     */
    private void percolate(int index, T item) {
        int parentIndex = 0;
        if (index > 0) { // If it's at the root, no need to percolate up, so parent index defaults to 0
            parentIndex =  getParentIndex(index);
        }
        if (this.heap[index].compareTo(this.heap[parentIndex]) < 0) { // Need to percolate up
            percolateUp(index, item);
        } else if (needsToPercolateDown(index)) { // Need to percolate down
            percolateDown(index, item);
        } else { // If it is in the right spot
            this.indices.put(item, index);
        }
    }

    /**
     * A method stub that you may replace with a helper method for swapping
     * the elements at two indices in the `heap` array.
     */
    private void swap(int a, int b) {
        // Swap values in heap array
        T tmpa = this.heap[a];
        T tmpb = this.heap[b];
        this.heap[a] = this.heap[b];
        this.heap[b] = tmpa;
        // Swap indices in dictionary
        this.indices.put(tmpa, b);
        this.indices.put(tmpb, a);
    }

    /**
     * Finds the parent of an element at a given index
     */
    private int getParentIndex(int index) {
        return (index - 1)/4;
    }

    /**
     * Finds the given child of an element (child 1, 2, 3, or 4)
     */
    private int getChild(int index, int child) {
        return (4 * index) + child;
    }

    /**
     * Determines whether a node needs to percolate down or not
     */
    private boolean needsToPercolateDown(int index) {
        for (int i = 1; i < 5; i++) {
            int child = getChild(index, i);
            if (child < this.heap.length) { // Make sure child index is within array bounds
                if (this.heap[child] != null) { // Makes sure child index has an element
                    if (this.heap[index].compareTo(this.heap[child]) > 0) { // Compare element with this child
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if an index is a leaf node
     */
    private boolean isALeaf(int index) {
        for (int i = 1; i < 5; i++) {
            int child = getChild(index, i);
            if (child < this.heap.length) { // Make sure child index is within array bounds
                if (this.heap[child] != null) { // Makes sure child index has an element
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return IPriorityQueue.toString(this);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayHeapIterator<>(this.heap, this.size());
    }

    private static class ArrayHeapIterator<T extends Comparable<T>> implements Iterator<T> {
        private final T[] heap;
        private final int size;
        private int index;

        ArrayHeapIterator(T[] heap, int size) {
            this.heap = heap;
            this.size = size;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < this.size;
        }

        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            T output = heap[this.index];
            this.index++;
            return output;
        }
    }
}
