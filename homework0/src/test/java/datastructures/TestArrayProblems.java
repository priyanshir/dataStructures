package datastructures;

import misc.BaseTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import problems.ArrayProblems;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

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
class TestArrayProblems extends BaseTest {

    @Test
    void testRotateRightGeneral() {
        int[] actual = {3, 8, 19, 7};
        int[] expected = {7, 3, 8, 19};

        ArrayProblems.rotateRight(actual);

        assertThat(actual, is(expected));
    }

    @Test
    void testRotateRightGeneral2() {
        int[] actual = {10, 20, 30, 40, 50, 60, 70};
        int[] expected = {70, 10, 20, 30, 40, 50, 60};

        ArrayProblems.rotateRight(actual);

        assertThat(actual, is(expected));
    }

    @Test
    void testRotateRightGeneral3() {
        int[] actual = {100, 200};
        int[] expected = {200, 100};

        ArrayProblems.rotateRight(actual);

        assertThat(actual, is(expected));
    }

    @Test
    void testRotateRightSingle() {
        int[] actual = {42};
        int[] expected = {42};

        ArrayProblems.rotateRight(actual);

        assertThat(actual, is(expected));
    }

    @Test
    void testRotateRightEmpty() {
        int[] actual = {};
        int[] expected = {};

        ArrayProblems.rotateRight(actual);

        assertThat(actual, is(expected));
    }

    @Test
    void testReverseGeneral1() {
        int[] actual = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expected = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        int[] reversed = ArrayProblems.reverse(actual);

        assertThat(actual, not(equalTo(reversed)));
        assertThat(reversed, is(expected));
    }

    @Test
    void testReverseGeneral2() {
        int[] actual = {1, 2, 3};
        int[] expected = {3, 2, 1};

        int[] reversed = ArrayProblems.reverse(actual);

        assertThat(actual, not(equalTo(reversed)));
        assertThat(reversed, is(expected));
    }

    @Test
    void testReverseSingle() {
        int[] actual = {1};
        int[] expected = {1};

        int[] reversed = ArrayProblems.reverse(actual);

        assertThat(reversed, is(expected));
    }

    @Test
    void testReverseEmpty() {
        int[] actual = {};
        int[] expected = {};

        int[] reversed = ArrayProblems.reverse(actual);

        assertThat(reversed, is(expected));
    }

    @Test
    void testToStringGeneral1() {
        int[] list = {1, 2, 3, 4, 5};
        String expected = "[1, 2, 3, 4, 5]";

        String arrayString = ArrayProblems.toString(list);

        assertThat(arrayString, is(expected));
    }

    @Test
    void testToStringGeneral2() {
        int[] list = {5, 7, 123, 12};
        String expected = "[5, 7, 123, 12]";

        String arrayString = ArrayProblems.toString(list);

        assertThat(arrayString, is(expected));
    }

    @Test
    void testToStringSingle() {
        int[] list = {1};
        String expected = "[1]";

        String arrayString = ArrayProblems.toString(list);

        assertThat(arrayString, is(expected));
    }

    @Test
    void testToStringEmpty() {
        int[] list = {};
        String expected = "[]";

        String arrayString = ArrayProblems.toString(list);

        assertThat(arrayString, is(expected));
    }
}
