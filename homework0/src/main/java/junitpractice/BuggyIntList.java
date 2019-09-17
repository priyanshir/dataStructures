package junitpractice;

import datastructures.LinkedIntList;

import java.util.HashSet;
import java.util.Set;

/*
 * WARNING: DO NOT MODIFY THIS FILE - we will be using this class as provided below when
 * we score your assignment (run the provided tests).
 *
 * If you modify it, you risk breaking our stuff in a not-fun way.
 */

/**
 * This is an extension of `LinkedIntList` that adds some more functionality, including a method
 * called `deleteElement` that has a bug.
 */

public class BuggyIntList extends LinkedIntList {

    protected BuggyIntList() {
        super();
    }

    protected BuggyIntList(int[] array) {
        super(array);
    }

    int get(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    int size() {
        ListNode current = front;
        int count = 0;
        Set<ListNode> seen = new HashSet<>();
        while (current != null) {
            assert !seen.contains(current) : "cycle detected when calling size()";
            seen.add(current);
            current = current.next;
            count++;
        }
        return count;
    }

    boolean isEmpty() {
        return size() == 0;
    }


    /**
     * Deletes a given element from the linked list. If there are multiple of
     * the same element, then only the first occurrence is deleted.
     *
     * @throws IllegalArgumentException if the given element is not found in the
     * linked list.
     */
    void deleteElement(int element) {
        ListNode current = front;
        boolean found = false;
        while (current != null) {
            if (current.data == element) {
                found = true;
                break;
            }
            current = current.next;
        }
        if (!found) {
            // We promise to throw an exception but we don't.
            return;
        }

        current = front;
        while (current.next != null) {
            if (current.next.data == element) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
    }
}
