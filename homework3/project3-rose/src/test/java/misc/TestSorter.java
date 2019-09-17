package misc;

import datastructures.lists.DoubleLinkedList;
import datastructures.lists.IList;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static datastructures.lists.IListMatcher.listContaining;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * See spec for details on what kinds of tests this class should include.
 */
@Tag("project3")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TestSorter extends BaseTest {
    @Test
    public void testSimpleUsage() {
        IList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        IList<Integer> top = Sorter.topKSort(5, list);
        assertThat(top, is(listContaining(15, 16, 17, 18, 19)));
    }
    @Test
    public void testExceptions() {
        IList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertThrows(IllegalArgumentException.class, () -> { Sorter.topKSort(-1, list); });
        assertThrows(IllegalArgumentException.class, () -> { Sorter.topKSort(2, null); });
    }
    @Test
    public void testEmptyLinkedList() {
        IList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        IList<Integer> top = Sorter.topKSort(0, list);
        assertThat(top.size(), is(0)); //should just be storing an empty DoubleLinkedList
    }
    @Test
    public void largerK() {
        IList<Integer> list = new DoubleLinkedList<>();
        list.add(99);
        list.add(0);
        list.add(-5);
        list.add(-4);
        list.add(2000);
        IList<Integer> top = Sorter.topKSort(10, list); //even though there isn't 10 elements

        assertThat(top.size(), is(5));
        assertThat(top, is(listContaining(-5, -4, 0, 99, 2000)));
    }
    @Test
    public void smallerK() {
        IList<Integer> list = new DoubleLinkedList<>();
        list.add(99);
        list.add(0);
        list.add(-5);
        list.add(-4);
        list.add(2000);
        IList<Integer> top = Sorter.topKSort(2, list);

        assertThat(top.size(), is(2));
        assertThat(top, is(listContaining(99, 2000)));
    }
    @Test
    public void testNegatives() {
        IList<Integer> list = new DoubleLinkedList<>();
        list.add(-100);
        list.add(-2);
        list.add(-4);
        list.add(-34);
        list.add(-1);

        IList<Integer> top = Sorter.topKSort(6, list);
        assertThat(top, is(listContaining(-100, -34, -4, -2, -1)));
    }
}
