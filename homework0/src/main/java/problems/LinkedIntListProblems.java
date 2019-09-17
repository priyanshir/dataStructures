package problems;

import datastructures.LinkedIntList;

// IntelliJ will complain that this is an unused import, but you should use `ListNode` variables
// in your solution, and then this error should go away.

import datastructures.LinkedIntList.ListNode;

/**
 * Parts b.vi, b.vii, and b.viii should go here.
 *
 * (Implement `reverse3`, `firstLast`, and `shift` as described by the spec.
 *  See the spec on the website for picture examples and more explanation!)
 *
 * REMEMBER THE FOLLOWING RESTRICTIONS:
 * - do not construct new `ListNode` objects (though you may have as many `ListNode` variables as
 *      you like).
 * - do not call any `LinkedIntList` methods
 * - do not construct any external data structures like arrays, queues, lists, etc.
 * - do not mutate the `data` field of any nodes; instead, change the list only by modifying links
 *      between nodes.
 * - your solution should run in linear time with respect to the number of elements in the list.
 */

public class LinkedIntListProblems {

    // Reverses the 3 elements in the `LinkedIntList` (assume there are only 3 elements).
    public static void reverse3(LinkedIntList list) { //no initial empty check since the list is predefined
        // with 3 elements
        ListNode temp = list.front;
        list.front = list.front.next.next; //make the front the end
        temp.next.next = temp;
        list.front.next = temp.next;
        temp.next = null;  //set the last pointer to null
    }
    // shifts all the elements in the odd indexes to the end (preserving the order)
    public static void shift(LinkedIntList list) {
        if (list.front != null && list.front.next != null && list.front.next.next != null) { //initial empty list check
            //and making sure there's at least 3 elements otherwise we don't have to do anything
            ListNode even  = list.front; //pointer to check even indeces
            ListNode odd = list.front.next; //pointer to check odd indeces
            ListNode oddFront = list.front.next; //second term (1st index) front of odd indeces
            while (odd != null && odd.next != null) { //checks to make sure there are still odd indeces left to shift
                even.next = odd.next; //skipping over odd index building even list
                even = even.next; //updating even pointer
                odd.next = even.next; //skipping over even index building odd list
                odd = odd.next; //updating odd pointer
            }
            //once it's done building the 2 lists append them
            even.next = oddFront;
        }
    }
    // moves the first element to the last position in the passed in linked list
    public static void firstLast(LinkedIntList list) {
        if (list.front != null && list.front.next != null) { //checking if 0/1 element
            ListNode temp = list.front;
            list.front = list.front.next;
            temp.next = null;
            ListNode curr = list.front;
            while (curr.next != null) { //updates curr to get to the last value
                curr = curr.next;
            } //curr should now be at the end
            curr.next = temp;
        }
    }
}
