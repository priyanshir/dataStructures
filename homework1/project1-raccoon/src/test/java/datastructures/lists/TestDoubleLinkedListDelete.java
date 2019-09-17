package datastructures.lists;

import datastructures.lists.DoubleLinkedList.Node;
import misc.BaseTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


import static datastructures.lists.TestDoubleLinkedList.makeBasicList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class should contain all the tests you implement to verify that your `delete` method behaves
 * as specified. Each test should run quickly; if your tests take longer than 1 second to run, they
 * may get timed out on the runners and during grading.
 */
@Tag("project1")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TestDoubleLinkedListDelete extends BaseTest {

    @Test
    void testExample() {
        /*
        Feel free to modify or delete this dummy test.

        Below is an example of using casting, so that Java lets us access
        the specific fields of DoubleLinkedList. If you wish, you may
        use this syntax to access the internal pointers within
        DoubleLinkedList objects. Being able to check the internal pointers
        will more easily let you be thorough in your tests. For reference, our
        secret tests will be checking that the internal pointers are correct to more
        easily check your solution.
         */
        IList<String> list = makeBasicList();

        Node<String> front = ((DoubleLinkedList<String>) list).front;
        Node<String> back = ((DoubleLinkedList<String>) list).back;
        assertThat(front.next, is(back.prev));
        assertThat(front.prev, is(nullValue()));
        assertThat(back.next, is(nullValue()));
        /*expected case for delete: returns deleted item (add a bunch of elements to list,
        make sure that that item is set to null and that everything else is pushed one spot left
        */
    }

    @Test
    void testDeleteIndexOutOfBounds() { //invalid input case, index is not within bounds
        IList<String> list = makeBasicList();

        assertThrows(IndexOutOfBoundsException.class, () -> {list.delete(6); });
        assertThrows(IndexOutOfBoundsException.class, () -> {list.get(6); });
        assertThrows(IndexOutOfBoundsException.class, () -> {list.delete(-3); });
    }

    @Test
    void testDeleteSingleElement() { //test that delete single element works properly
        //edge case
        IList<Integer> list = new DoubleLinkedList<>();
        list.add(5);

        assertThat(list.delete(0), is(5));
        assertThat(list.isEmpty(), is(true));

        list.add(null);
        list.add(null);
        assertThat(list.get(1), is(nullValue()));
        assertThat(list.delete(1), is(nullValue()));
        assertThat(list.set(0, 5), is(nullValue()));

    }

    @Test
    void testStringObjectsFrontBack() { //basic test case, making sure front and back work correctly
        //also tests delete with mutators
        IList<String> list = new DoubleLinkedList<>();

        list.add("and");
        list.add("ball");
        list.add("cat");

        Node<String> front = ((DoubleLinkedList<String>) list).front;
        Node<String> back = ((DoubleLinkedList<String>) list).back;

        assertThat(front.data, is("and"));
        assertThat(list.delete(0), is("and"));
        assertThat(list.size(), is(2));
        assertThat(list.delete(0), is("ball"));
        assertThat(list.size(), is(1));
        assertThat(list.delete(0), is("cat"));
        assertThat(list.size(), is(0));
        assertThat(list.isEmpty(), is(true));

    }


    @Test
    void testStringObjectOneAndTwoElement() { //test that delete in empty list returns null
        IList<String> list = makeBasicList();

        Node<String> front = ((DoubleLinkedList<String>) list).front;
        Node<String> back = ((DoubleLinkedList<String>) list).back;

        assertThat(front.next, is(back.prev));
        assertThat(front.prev, is(nullValue()));
        assertThat(back.next, is(nullValue()));
    }

    @Test
    void testDeleteTwoElements() { //test that delete for two elements works for both elements
        IList<Integer> list = new DoubleLinkedList<>();
        list.add(7);
        list.add(9);

        assertThat(list.delete(0), is(7));
        assertThat(list.size(), is(1));

        list.add(7);

        assertThat(list.delete(1), is(7));
        assertThat(list.size(), is(1));

        Node<Integer> front = ((DoubleLinkedList<Integer>) list).front;
        Node<Integer> back = ((DoubleLinkedList<Integer>) list).back;

        assertThat(front.prev, is(nullValue()));
        assertThat(back.data, is(9));
        assertThat(back.next, is(nullValue()));
    }

    @Test
    void testListBasic() { //adds a bunch of elements, tests get and set
        IList<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);

        assertThat(list.size(), is(15)); //tests, get, set and delete with many elements
        assertThat(list.set(2, 16), is(3));
        assertThat(list.get(2), is(16));
        assertThat(list.delete(3), is(4));
        assertThat(list.get(2), is(16));
        assertThat(list.size(), is(14));
        assertThat(list.get(13), is(15));

        Node<Integer> front = ((DoubleLinkedList<Integer>) list).front;
        Node<Integer> back = ((DoubleLinkedList<Integer>) list).back;
        assertThat(front.data, is(1));
        assertThat(back.data, is(15));
    }

    @Test
    void testDeleteExpected() { //test delete in normal circumstances.
        IList<String> list = makeBasicList(); //a, b, c
        list.add("d");
        list.add("e");
        list.delete(3);
        assertThat(list.toString(), is("[a, b, c, e]"));
        list.delete(1);
        assertThat(list.toString(), is("[a, c, e]"));
    }

    @Test
    void testDeleteEmptyList() { //tests that exception is thrown when deleting from empty list.
        IList<String> list = makeBasicList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.delete(0);
        }
        System.out.print(list.toString());
        assertThat(list.isEmpty(), is(true));
        assertThrows(IndexOutOfBoundsException.class, () -> {list.delete(0); });
    }

    @Test
    void testDeleteNull() { //adds and deletes a null element
        IList<String> list = makeBasicList();
        list.add(null);
        assertThat(list.delete(3), is(nullValue()));
        list.add("f");
        list.add("g");
        list.insert(2, null);
        assertThat(list.delete(2), is(nullValue()));
        list.insert(0, null);
        assertThat(list.delete(0), is(nullValue()));
    }

}