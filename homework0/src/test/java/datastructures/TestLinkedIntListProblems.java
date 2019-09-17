package datastructures;

import misc.BaseTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import problems.LinkedIntListProblems;

import static misc.HasNoCycle.hasNoCycle;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.emptyIterable;

/*
 * WARNING: These tests determine your grade for this assignment.
 * You don't need to change these tests, but it may be useful to temporarily add extra
 * printing or code for debugging.
 *
 * If you do modify this file, take care to remember to revert your changes afterwards.
 *
 * (If you make changes that affect the results of the tests below, you might trick yourself into
 * thinking your code is correct when it really isn't, so please be careful about changing things.)
 */

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class TestLinkedIntListProblems extends BaseTest {
    private static final String RESPONSE_PROMPT = "your list: ";

    @Test
    void testReverse3() {
        LinkedIntList list = new LinkedIntList(new int[]{3, 4, 5});
        LinkedIntListProblems.reverse3(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, contains(5, 4, 3));
    }

    @Test
    void testFirstLastEmpty() {
        LinkedIntList list = new LinkedIntList();
        LinkedIntListProblems.firstLast(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, emptyIterable());
    }

    @Test
    void testFirstLast1Element() {
        LinkedIntList list = new LinkedIntList(new int[]{42});
        LinkedIntListProblems.firstLast(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, contains(42));
    }

    @Test
    void testFirstLast2Elements() {
        LinkedIntList list = new LinkedIntList(new int[]{42, 99});
        LinkedIntListProblems.firstLast(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, contains(99, 42));
    }

    @Test
    void testFirstLastGeneral1() {
        LinkedIntList list = new LinkedIntList(new int[]{18, 4, 27, 9, 54, 5, 63});
        LinkedIntListProblems.firstLast(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, contains(4, 27, 9, 54, 5, 63, 18));
    }

    @Test
    void testFirstLastDuplicates() {
        LinkedIntList list = new LinkedIntList(new int[]{3, 7, 3, 3});
        LinkedIntListProblems.firstLast(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, contains(7, 3, 3, 3));
    }

    @Test
    void testShiftEmpty() {
        LinkedIntList list = new LinkedIntList();
        LinkedIntListProblems.shift(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, emptyIterable());
    }

    @Test
    void testShift2Elements() {
        LinkedIntList list = new LinkedIntList(new int[]{0, 1});
        LinkedIntListProblems.shift(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, contains(0, 1));
    }

    @Test
    void testShift3Elements() {
        LinkedIntList list = new LinkedIntList(new int[]{0, 1, 2});
        LinkedIntListProblems.shift(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, contains(0, 2, 1));
    }

    @Test
    void testShiftConsecutiveDuplicates() {
        LinkedIntList list = new LinkedIntList(new int[]{3, 3, 3, 3, 4});
        LinkedIntListProblems.shift(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, contains(3, 3, 4, 3, 3));
    }

    @Test
    void testShiftSorted() {
        LinkedIntList list = new LinkedIntList(new int[]{0, 1, 2, 3, 4, 5, 6, 7});
        LinkedIntListProblems.shift(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, contains(0, 2, 4, 6, 1, 3, 5, 7));
    }

    @Test
    void testShiftGeneralOddLength() {
        LinkedIntList list = new LinkedIntList(new int[]{4, 17, 29, 3, 8, 2, 28, 5, 7});
        LinkedIntListProblems.shift(list);
        assertThat(list, hasNoCycle());
        assertThat(RESPONSE_PROMPT + list.toString(),
                list, contains(4, 29, 8, 28, 7, 17, 3, 2, 5));
    }
}
