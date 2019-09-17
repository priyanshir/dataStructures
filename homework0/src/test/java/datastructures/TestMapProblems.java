package datastructures;

import misc.BaseTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import problems.MapProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class TestMapProblems extends BaseTest {

    @Test
    void testIntersectGeneral1() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Janet", 87);
        map1.put("Logan", 62);
        map1.put("Whitaker", 46);
        map1.put("Alyssa", 100);
        map1.put("Stefanie", 80);
        map1.put("Jeff", 88);
        map1.put("Kim", 52);
        map1.put("Sylvia", 95);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("Logan", 62);
        map2.put("Kim", 52);
        map2.put("Whitaker", 52);
        map2.put("Jeff", 88);
        map2.put("Stefanie", 80);
        map2.put("Brian", 60);
        map2.put("Lisa", 83);
        map2.put("Sylvia", 87);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Logan", 62);
        expected.put("Stefanie", 80);
        expected.put("Jeff", 88);
        expected.put("Kim", 52);

        Map<String, Integer> actual = MapProblems.intersect(map1, map2);
        assertThat(actual, is(expected));
    }

    @Test
    void testIntersectGeneral2() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("d", 4);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("b", 2);
        map2.put("c", 5);
        map2.put("d", 4);
        map2.put("e", 4);
        map2.put("f", 1);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("b", 2);
        expected.put("d", 4);

        Map<String, Integer> actual = MapProblems.intersect(map1, map2);
        assertThat(actual, is(expected));
    }

    @Test
    void testIntersectSameMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("d", 4);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("a", 1);
        map2.put("b", 2);
        map2.put("c", 3);
        map2.put("d", 4);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        expected.put("b", 2);
        expected.put("c", 3);
        expected.put("d", 4);

        Map<String, Integer> actual = MapProblems.intersect(map1, map2);
        assertThat(actual, is(expected));
    }

    @Test
    void testIntersectMap2SupersetMap1() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("d", 4);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("x", 0);
        map2.put("a", 1);
        map2.put("b", 2);
        map2.put("c", 3);
        map2.put("d", 4);
        map2.put("e", 5);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        expected.put("b", 2);
        expected.put("c", 3);
        expected.put("d", 4);

        Map<String, Integer> actual = MapProblems.intersect(map1, map2);
        assertThat(actual, is(expected));
    }

    @Test
    void testIntersectMap1SupersetMap2() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("d", 4);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("x", 0);
        map2.put("a", 1);
        map2.put("b", 2);
        map2.put("c", 3);
        map2.put("d", 4);
        map2.put("e", 5);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        expected.put("b", 2);
        expected.put("c", 3);
        expected.put("d", 4);

        Map<String, Integer> actual = MapProblems.intersect(map2, map1);
        assertThat(actual, is(expected));
    }

    @Test
    void testIntersectDisjointMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("d", 4);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("a", 5);
        map2.put("b", 6);
        map2.put("c", 7);
        map2.put("d", 8);

        Map<String, Integer> expected = new HashMap<>();

        Map<String, Integer> actual = MapProblems.intersect(map1, map2);
        assertThat(actual, is(expected));
    }

    @Test
    void testIntersectEmptyMap2() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> expected = new HashMap<>();
        Map<String, Integer> actual = MapProblems.intersect(map1, map2);
        assertThat(actual, is(expected));
    }

    @Test
    void testIntersectEmptyMap1() {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("a", 1);
        Map<String, Integer> expected = new HashMap<>();
        Map<String, Integer> actual = MapProblems.intersect(map1, map2);
        assertThat(actual, is(expected));
    }

    @Test
    void testContains3False() {
        List<String> input = Arrays.asList("to", "be", "or", "not", "to", "be", "hamlet");
        assertThat(MapProblems.contains3(input), is(false));
    }

    @Test
    void testContains3True() {
        List<String> input = Arrays.asList("to", "be", "or", "not", "to", "be", "to", "be", "hamlet");
        assertThat(MapProblems.contains3(input), is(true));
    }

    @Test
    void testContains3Empty() {
        List<String> input = new ArrayList<>();
        assertThat(MapProblems.contains3(input), is(false));
    }

}
