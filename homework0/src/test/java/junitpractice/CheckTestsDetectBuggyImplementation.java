package junitpractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * WARNING: DO NOT MODIFY THIS FILE - we will be using this class as provided below when
 * we score your assignment (run the provided tests).
 *
 * If you modify it, you risk breaking our stuff in a not-fun way.
 */

/**
 * Runs tests from `TestBuggyDeleteElement` but expects test failures for tests that we expect the
 * buggy solution to fail.
 */
class CheckTestsDetectBuggyImplementation extends TestBuggyDeleteElement {
    @Override
    @Test
    void testDeleteFromFront() {
        assertThrows(AssertionError.class, super::testDeleteFromFront);
    }

    @Override
    @Test
    void testThrowsIllegalArgumentException() {
        assertThrows(AssertionError.class, super::testThrowsIllegalArgumentException);
    }
}
