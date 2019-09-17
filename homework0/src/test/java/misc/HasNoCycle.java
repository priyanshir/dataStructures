package misc;

import misc.exceptions.CycleDetectedException;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.util.Iterator;

/*
 * WARNING: DO NOT MODIFY THIS FILE - we will be using this class as provided below when
 * we score your assignment (run the provided tests).
 *
 * If you modify it, you risk breaking our stuff in a not-fun way.
 */

public class HasNoCycle extends BaseMatcher<Iterable<Integer>> {

    public void describeMismatch(Object item, Description description) {
        description.appendText("cycle detected: ").appendText(item.toString());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("there is no cycle");
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean matches(Object actual) {
        if (!(actual instanceof Iterable)) {
            return true;
        }
        Iterator<Integer> itr = ((Iterable<Integer>) actual).iterator();
        try {
            while (itr.hasNext()) {
                itr.next();
            }
            return true;
        } catch (CycleDetectedException e) {
            return false;
        }
    }

    public static Matcher<Iterable<Integer>> hasNoCycle() {
        return new HasNoCycle();
    }
}
