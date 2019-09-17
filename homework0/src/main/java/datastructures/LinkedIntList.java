package datastructures;

import misc.exceptions.CycleDetectedException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/*
 * WARNING: DO NOT MODIFY THIS FILE - we will be using this class as provided below when
 * we score your assignment (run the provided tests).
 *
 * If you modify it, you risk breaking our stuff in a not-fun way.
 */

/**
 * This class represents a linked list of `int` data. Each piece of data is represented as a
 * `ListNode` object that stores some `int` data (the `data` field), as well as the `ListNode`
 * object that comes after in the list order (the `next` field).
 *
 * Note that this data structure is not quite useful in its current state. There are a couple
 * useful methods (and it's actually more useful than `IntTree`), but it needs a lot more
 * to meet the functionality of the official Java `LinkedList`.
 *
 * Don't worry though - we'll implement a more speed-efficient and useful linked list very soon!
 * Stay tuned!
 */

public class LinkedIntList implements Iterable<Integer> {

    public ListNode front;

    protected LinkedIntList() { }

    protected LinkedIntList(int[] array) {
        // this is inefficient
        // for (int n : array) {
        //    this.add(n);
        // }

        if (array.length != 0) {
            front = new ListNode(array[0]);
            ListNode temp = front;
            for (int i = 1; i < array.length; i++) {
                temp.next = new ListNode(array[i]);
                temp = temp.next;
            }
        }
    }

    // for testing

    // Returns a comma-separated String representation of this list.
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            Set<ListNode> seen = new HashSet<>();
            String result = "[<" + front.data + ">";
            seen.add(front);
            ListNode current = front.next;
            while (current != null) {
                if (!seen.contains(current)) {
                    result += ", <" + current.data + ">";
                    seen.add(current);
                    current = current.next;
                } else {
                    return result + ", <" + current.data + "> CYCLE DETECTED HERE ...";
                }
            }
            result += "]";
            return result;
        }
    }

    public static class ListNode {
        public final int data;
        public ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Iterator<Integer> iterator() {
        return new LinkedIntListIterator(this.front);
    }

    private static final class LinkedIntListIterator implements Iterator<Integer> {
        private ListNode next;
        private Set<ListNode> seen;

        private LinkedIntListIterator(ListNode start) {
            this.next = start;
            this.seen = new HashSet<>();
        }

        public boolean hasNext() {
            return next != null;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            ListNode temp = next;
            if (seen.contains(temp)) {
                throw new CycleDetectedException();
            }
            next = next.next;
            seen.add(temp);
            return temp.data;
        }
    }
}
