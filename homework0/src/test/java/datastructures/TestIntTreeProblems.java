package datastructures;

import misc.BaseTest;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import problems.IntTreeProblems;

import static misc.HasNoCycle.hasNoCycle;
import static org.hamcrest.CoreMatchers.is;
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

@TestMethodOrder(Alphanumeric.class)
class TestIntTreeProblems extends BaseTest {

    @Test
    void testDepthSumEmptyTree() {
        IntTree tree = new IntTree(new Integer[0]);
        assertThat(IntTreeProblems.depthSum(tree), is(0));
    }

    @Test
    void testDepthSum1Element() {
        IntTree tree = new IntTree(new Integer[]{12});
        assertThat(IntTreeProblems.depthSum(tree), is(12));
    }

    @Test
    void testDepthSumHeight3() {
        IntTree tree = new IntTree(new Integer[]{9, 7, 6, 3, 2, null, 4, null, null,
                5, null, null, null, null, 2});
        assertThat(IntTreeProblems.depthSum(tree), is(90));
    }

    @Test
    void testDepthSumHeight2() {
        IntTree tree = new IntTree(new Integer[]{3, 5, 2, 1, null, 4, 6, });
        assertThat(IntTreeProblems.depthSum(tree), is(50));
    }

    @Test
    void testDepthSumNegatives() {
        IntTree tree = new IntTree(new Integer[]{19, 47, 63, 23, -2, null, 94, null,
                null, 55, null, null, null, null, 28});
        assertThat(IntTreeProblems.depthSum(tree), is(916));
    }

    @Test
    void testDepthSumAllRightSide() {
        IntTree tree = new IntTree(new Integer[]{2, null, 1, null, null, 7, 6, null,
                null, null, null, 4, null, null, 9, null, null, null, null, null,
                null, null, null, 3, 5, null, null,  null, null,  8});
        assertThat(IntTreeProblems.depthSum(tree), is(175));
    }

    @Test
    void testDepthSumFull() {
        IntTree tree = new IntTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                12, 13, 14, 15});
        assertThat(IntTreeProblems.depthSum(tree), is(445));
    }

    @Test
    void testRemoveLeavesEmpty() {
        IntTree actual = new IntTree();
        IntTreeProblems.removeLeaves(actual);
        IntTree expected = new IntTree();
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testRemoveLeaves1Element() {
        IntTree actual = new IntTree(new Integer[]{12});
        IntTreeProblems.removeLeaves(actual);
        IntTree expected = new IntTree();
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testRemoveLeavesOnce() {
        IntTree actual = new IntTree(new Integer[]{7, 3, 9, 1, 4, 6, 8, null, null,
                null, null, null, null, null, 0});
        IntTreeProblems.removeLeaves(actual);
        IntTree expected = new IntTree(new Integer[]{7, 3, 9, null, null, null, 8});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testRemoveLeavesRepeatedly1() {
        IntTree actual = new IntTree(new Integer[]{7, 3, 9, 1, 4, 6, 8, null, null,
                null, null, null, null, null, 0});
        IntTreeProblems.removeLeaves(actual);
        IntTree expected = new IntTree(new Integer[]{7, 3, 9, null, null, null, 8});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{7, null, 9});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{7});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree();
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testRemoveLeavesRepeatedlySymmetrical() {
        IntTree actual1 = new IntTree(new Integer[]{6, 5, 4, null, null, null, 1,
                null, null, null, null, null, null, 3, 2});
        IntTreeProblems.removeLeaves(actual1);
        IntTree expected1 = new IntTree(new Integer[]{6, null, 4, null, null, null, 1});
        assertThat(actual1, hasNoCycle());
        assertThat(actual1, is(expected1));
        IntTreeProblems.removeLeaves(actual1);
        expected1 = new IntTree(new Integer[]{6, null, 4});
        assertThat(actual1, hasNoCycle());
        assertThat(actual1, is(expected1));
        IntTreeProblems.removeLeaves(actual1);
        expected1 = new IntTree(new Integer[]{6});
        assertThat(actual1, hasNoCycle());
        assertThat(actual1, is(expected1));
        // testing the same structure tree as above but mirrored horizontally (some different values though)
        IntTree actual2 = new IntTree(new Integer[]{6, 5, 2, 4,  null, null, null, 1, 3});
        IntTreeProblems.removeLeaves(actual2);
        IntTree expected2 = new IntTree(new Integer[]{6, 5, null, 4});
        assertThat(actual2, hasNoCycle());
        assertThat(actual2, is(expected2));
        IntTreeProblems.removeLeaves(actual2);
        expected2 = new IntTree(new Integer[]{6, 5});
        assertThat(actual2, hasNoCycle());
        assertThat(actual2, is(expected2));
        IntTreeProblems.removeLeaves(actual2);
        expected2 = new IntTree(new Integer[]{6});
        assertThat(actual2, hasNoCycle());
        assertThat(actual2, is(expected2));
    }

    @Test
    void testRemoveLeavesLinkedListLeft() {
        IntTree actual = new IntTree(new Integer[]{4, 2, null, 3, null, null, null, 1});
        IntTreeProblems.removeLeaves(actual);
        IntTree expected = new IntTree(new Integer[]{4, 2, null, 3});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{4, 2});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{4});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree();
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testRemoveLeavesLinkedListRight() {
        IntTree actual = new IntTree(new Integer[]{2, null, 3, null, null, null, 4,
                null, null, null, null, null, null, null, 1});
        IntTreeProblems.removeLeaves(actual);
        IntTree expected = new IntTree(new Integer[]{2, null, 3, null, null, null, 4});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{2, null, 3});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{2});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree();
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testRemoveLeavesLinkedListZigZag() {
        IntTree actual = new IntTree(new Integer[]{6, 5, null, null, 4,  null, null,
                null, null, 3, null, null, null, null, null, /**/ null, null, null,
                null, null, 2, null, null, /**/ null, null, null, null, null, null,
                null, null, /**/  null, null, null, null, null, null, null, null,
                null, null, 1});
        IntTreeProblems.removeLeaves(actual);
        IntTree expected = new IntTree(new Integer[]{6, 5, null, null, 4,  null,
                null, null, null, 3, null, null, null, null, null, /**/ null, null,
                null, null, null, 2});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{6, 5, null, null, 4,  null, null, null, null, 3});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{6, 5, null, null, 4});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{6, 5});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{6});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testRemoveLeavesFull() {
        IntTree actual = new IntTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                12, 13, 14, 15});
        IntTreeProblems.removeLeaves(actual);
        IntTree expected = new IntTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{1, 2, 3});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree(new Integer[]{1});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
        IntTreeProblems.removeLeaves(actual);
        expected = new IntTree();
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testTrimEmpty() {
        IntTree actual = new IntTree();
        IntTreeProblems.trim(actual, 40, 1300);
        IntTree expected = new IntTree();
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testTrimRemoveGeneral() {
        IntTree actual = new IntTree(new Integer[]{50, 38, 90, 14, 42, 54, null,
                8, 20, null, null, null, 72, null, null, /*newrow*/ null, null,
                null, 26, null, null, null, null, null, null, 61, 83});
        IntTreeProblems.trim(actual, 25, 75);
        IntTree expected = new IntTree(new Integer[]{50, 38, 54, 26, 42, null, 72,
                null, null, null, null, null, null, 61});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testTrimMinBiggerThanRoot() {
        IntTree actual = new IntTree(new Integer[]{50, 38, 90, 14, 42, 54, null,
                8, 20, null, null, null, 72, null, null, /*newrow*/ null, null,
                null, 26, null, null, null, null, null, null, 61, 83});
        IntTreeProblems.trim(actual, 52, 65);
        IntTree expected = new IntTree(new Integer[]{54, null, 61});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testTrimMaxSmallerThanRoot() {
        IntTree actual = new IntTree(new Integer[]{50, 38, 90, 14, 42, 54, null,
                8, 20, null, null, null, 72, null, null, /*newrow*/ null, null,
                null, 26, null, null, null, null, null, null, 61, 83});
        IntTreeProblems.trim(actual, 18, 42);
        IntTree expected = new IntTree(new Integer[]{38, 20, 42, null, 26});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testTrimMaxLessThanValues() {
        IntTree actual = new IntTree(new Integer[]{50, 38, 90, 14, 42, 54, null,
                8, 20, null, null, null, 72, null, null, /*newrow*/ null, null,
                null, 26, null, null, null, null, null, null, 61, 83});
        IntTreeProblems.trim(actual, -90, -50);
        IntTree expected = new IntTree();
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testTrimMinGreaterThanValues() {
        IntTree actual = new IntTree(new Integer[]{50, 38, 90, 14, 42, 54, null,
                8, 20, null, null, null, 72, null, null, /*newrow*/ null, null,
                null, 26, null, null, null, null, null, null, 61, 83});
        IntTreeProblems.trim(actual, 120, 500);
        IntTree expected = new IntTree();
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testTrimMinEqualsMax() {
        IntTree actual = new IntTree(new Integer[]{50, 38, 90, 14, 42, 54, null,
                8, 20, null, null, null, 72, null, null, /*newrow*/ null, null,
                null, 26, null, null, null, null, null, null, 61, 83});
        IntTreeProblems.trim(actual, 50, 50);
        IntTree expected = new IntTree(new Integer[]{50});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }

    @Test
    void testTrimLargeRange() {
        IntTree actual = new IntTree(new Integer[]{50, 38, 90, 14, 42, 54, 1100,
                null, null, null, null, null, null, 99, 1500, null, null, null,
                null, null, null, null, null, null, null, null, null, null,
                null, 1250});
        IntTreeProblems.trim(actual, 40, 1300);
        IntTree expected = new IntTree(new Integer[]{50, 42, 90, null, null,
                54, 1100, null, null, null, null, null, null, 99, 1250});
        assertThat(actual, hasNoCycle());
        assertThat(actual, is(expected));
    }
}
