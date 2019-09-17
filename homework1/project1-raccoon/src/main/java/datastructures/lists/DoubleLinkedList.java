package datastructures.lists;

import datastructures.EmptyContainerException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Note: For more info on the expected behavior of your methods:
 * @see IList
 * (You should be able to control/command+click "IList" above to open the file from IntelliJ.)
 */
public class DoubleLinkedList<T> implements IList<T> {
    /*
    Warning:
    You may not rename these fields or change their types.
    We will be inspecting these in our secret tests.
    You also may not add any additional fields.

    Note: The fields below intentionally omit the "private" keyword. By leaving off a specific
    access modifier like "public" or "private" they become package-private, which means anything in
    the same package can access them. Since our tests are in the same package, they will be able
    to test these properties directly.
     */
    Node<T> front;
    Node<T> back;
    int size;

    public DoubleLinkedList() {
        this.front = null;
        this.back = null;
        this.size = 0;
    }

    @Override
    public void add(T item) {
        if (front == null && back == null) { //empty case
            Node<T> newNode = new Node<T>(null, item, null);
            front = newNode;
            back = newNode;
        } else {
            Node<T> newNode = new Node<T>(back, item, null);
            back.next = newNode;
            back = newNode;
        }
        this.size++; //update the size
    }

    @Override
    public T remove() {
        checkEmptyContainer();
        T result = back.data; //saves a pointer to the last element in list
        if (this.size == 1) { //only one element
            front = null;
            back = null;
        }
        else { //reorder the list
            back = back.prev;
            back.next = null;
        }
        this.size--; //decrement size
        return result;
    }

    @Override
    public T get(int index) {

        if (this.size() <= index || index < 0) { //if index is not within range
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) { //1st element case
            return this.front.data;
        }

        Node<T> current;
        current = findGetIndex(index);
        return current.data; //falls out of while and index == count, thus return the node
    }

    @Override
    public T set(int index, T item) {
        checkEmptyContainer();
        if (this.size() <= index || index < 0) { //if index is not within range
            throw new IndexOutOfBoundsException();
        }

        Node<T> current;
        current = findGetIndex(index);
        Node<T> old = current;
        T result = old.data; //store the data to return, now we can do whatever to the node.
        Node<T> newNode = new Node<T>(old.prev, item, old.next);

        if (index == (this.size - 1)) { //check if setting back
            this.back = newNode;
        }

        if (index == 0){ //check if setting front
            this.front = newNode;
        }

        if (index > 0) { //if NOT setting front, connect previous node.
            old.prev.next = newNode;
        }

        if (index < this.size - 1) { //if NOT setting back, connect next node.
            old.next.prev = newNode;
        }

        return result;
    }

    //Finds the correct node for get and set starting from most efficient end of the list.
    private Node<T> findGetIndex(int index) {
        Node<T> current;

        if (index > this.size/2) { //more efficient to start at back
            int count = this.size - 1; //last index to start at
            current = this.back;
            while (count != index) {
                current = current.prev;
                count--;
            }
        } else { //more efficient to start at front
            int count = 0;
            current = this.front;
            while (count != index) {
                current = current.next;
                count++;
            }
        }
        return current;
    }

    @Override
    public void insert(int index, T item) {

        if (index < 0 || index >= this.size() + 1) { //index out of range
            throw new IndexOutOfBoundsException();
        }

        if (isEmpty()) { //if the list is empty
            add(item);
        }
        else if (index == 0) { //if inserting at front
            Node<T> newNode = new Node<T>(null, item, this.front);
            this.front = newNode;
            this.front.next.prev = newNode; //ADDED THIS PART TO MAKE SURE FRONT/BACKS ARE BEING SET
            size++;
        } else if (index == this.size) { //if inserting at back
            Node<T> newNode = new Node<T>(this.back, item, null);
            this.back.next = newNode;
            this.back = newNode;
            size++;
        } else { //general case
            if (index > (this.size/2)) { //if starting from the back will be faster.
                Node<T> curr = findIndexFromBack(index);
                Node<T> newNode = new Node<T>(curr.prev, item, curr);
                newNode.next.prev = newNode;
                newNode.prev.next = newNode;
            } else { //if starting from front will be faster.
                Node<T> curr = findIndexFromFront(index);
                Node<T> newNode = new Node<T>(curr, item, curr.next);
                newNode.prev.next = newNode;
                newNode.next.prev = newNode;
            }
            size++;
        }
    }

    @Override
    public T delete(int index) {

        if (index < 0 || index >= this.size()) { //index out of range
            throw new IndexOutOfBoundsException();
        }

        T result;
        if (this.size == 1) { //deleting single element
            result = front.data;
            this.front = null;
            this.back = null;
            this.size--;
            return result;
        } else if (size == 2) { //deleting from a list of two elements
            if (index == 0) {
                result = front.data;
                this.front = front.next;
                this.back.prev = null;
            } else { //index == 1
                result = back.data;
                this.back = back.prev;
                this.front.next = null;
            }
            this.size--;
            return result;
        } else if (index == 0) { //deleting at front
            result = front.data;
            this.front = this.front.next;
            this.front.prev = null;
            this.size--;
            return result;
        } else if (index == this.size - 1) { //deleting at back
            result = back.data;
            this.back = this.back.prev;
            this.back.next = null;
            this.size--;
            return result;
        } else { //general case, guaranteed to be at least size 3.
            if (index > (this.size/2)) { //closer to back
                Node<T> curr = findIndexFromBack(index);
                result = curr.prev.data;
                curr.prev = curr.prev.prev;
                curr.prev.next = curr;
            } else { //closer to front
                Node<T> curr = findIndexFromFront(index);
                result = curr.next.data;
                curr.next = curr.next.next;
                curr.next.prev = curr;
            }
            this.size--;
            return result;
        }
    }

    //Reaches the correct node for insertion/deletion when starting from the back of the list.
    private Node<T> findIndexFromBack(int index) {
        int count = this.size - 1;
        Node<T> curr = this.back;
        while (count > index + 1) {
            count--;
            curr = curr.prev;
        } //ends at next node of insertion

        return curr;
    }

    private Node<T> findIndexFromFront(int index) {
        int count = 0;
        Node<T> curr = this.front;
        while (count < index - 1) {
            count++;
            curr = curr.next;
        } //ends at previous node of insertion

        return curr;
    }

    @Override
    public int indexOf(T item) {
        Node<T> current = this.front;
        int index = 0;
        while (current != null) {
            if (item != null) {
                if (current.data.equals(item)) {
                    return index;
                }
            } else {
                if (current.data == null) {
                    return index;
                }
            }
            current = current.next;
            index++;
        }
        return -1; //item not found
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(T other) {
        Node<T> current = this.front;
        while (current != null) {
            if (other != null && current.data != null) {
                if (current.data.equals(other)) {
                    return true;
                }
            } else {
                if (current.data == null) {
                    return true;
                }
            }
            current = current.next;
        }
        return false; //item not found
    }

    @Override
    public String toString() {
        //return super.toString();

        /*
        After you've implemented the iterator, comment out the line above and uncomment the line
        below to get a better string representation for objects in assertion errors and in the
        debugger.
        */

        return IList.toString(this);
    }

    //Checks if the list is empty. If it is, throws new EmptyContainerException.
    private void checkEmptyContainer() throws EmptyContainerException {
        if (this.isEmpty()) { //if empty
            throw new EmptyContainerException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        /*
        Note: we have provided a part of the implementation of an iterator for you. You should
        complete the methods stubs in the DoubleLinkedListIterator inner class at the bottom of
        this file. You do not need to change this method.
        */
        return new DoubleLinkedListIterator<>(this.front);
    }

    static class Node<E> {
        // You may not change the fields in this class or add any new fields.
        final E data;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        Node(E data) {
            this(null, data, null);
        }

        // Feel free to add additional constructors or methods to this class.
    }

    private static class DoubleLinkedListIterator<T> implements Iterator<T> {
        // You should not need to change this field, or add any new fields.
        private Node<T> next;

        public DoubleLinkedListIterator(Node<T> front) {
            // You do not need to make any changes to this constructor.
            this.next = front;
        }

        /**
         * Returns `true` if the iterator still has elements to look at;
         * returns `false` otherwise.
         */
        public boolean hasNext() {
            return this.next != null;
        }

        /**
         * Returns the next item in the iteration and internally updates the
         * iterator to advance one element forward.
         *
         * @throws NoSuchElementException if we have reached the end of the iteration and
         *         there are no more elements to look at.
         */
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            } else {
                Node<T> result = this.next;
                this.next = this.next.next;
                return result.data;
            }
        }
    }
}
