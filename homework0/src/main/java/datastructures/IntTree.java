package datastructures;

import misc.exceptions.CycleDetectedException;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * WARNING: DO NOT MODIFY THIS FILE - we will be using this class as provided below when
 * we score your assignment (run the provided tests).
 *
 * If you modify it, you risk breaking our stuff in a not-fun way.
 */

/**
 * This class represents a binary tree that can store `int` data. Specifically, each element
 * is represented as an `IntTreeNode` that can be connected to its two potential "child"
 * `IntTreeNode`s, the `left` and `right` field of any `IntTreeNode`.
 *
 * Note that this data structure is actually not that useful in its current state, since there
 * aren't many useful methods.
 *
 * We will learn about more useful tree-based data structures later, and understanding how to
 * program with binary trees will be helpful for that future occasion.
 */

public class IntTree implements Iterable<Integer> {
    public IntTreeNode overallRoot;
    private int hashCode;

    protected IntTree() {
        hashCode = 0;
        overallRoot = null;
    }

    protected IntTree(Integer[] input) {
        hashCode = 0;
        overallRoot = insertLevelOrder(input, 0);
    }

    private IntTreeNode insertLevelOrder(Integer[] arr, int i) {
        if (i < arr.length && arr[i] != null) {
            hashCode = hashCode * 31 + arr[i];
            IntTreeNode root = new IntTreeNode(arr[i]);
            root.left = insertLevelOrder(arr, 2 * i + 1);
            root.right = insertLevelOrder(arr, 2 * i + 2);
            return root;
        }
        return null;
    }

    public String toString() {
        // return toString(overallRoot, new HashSet<>());
        return System.lineSeparator() + toStringSideways();
    }

    private String toString(IntTreeNode root, Set<IntTreeNode> seen) {
        if (root == null) {
            return "empty";
        } else {
            if (seen.contains(root)) {
                return "!!cycle!!";
            }
            seen.add(root);
            if (root.left == null && root.right == null) {
                return "" + root.data;
            } else {
                return "(" + root.data + ", " +  toString(root.left, seen) + ", " + toString(root.right, seen) + ")";
            }
        }
    }

    public String toStringSideways() {
        return toStringSideways(overallRoot, 0, new HashSet<>());
    }

    // post: prints in reversed preorder the tree with given root, indenting
    //       each line to the given level
    private String toStringSideways(IntTreeNode root, int level, Set<IntTreeNode> seen) {
        String result = "";
        if (root != null) {
            if (seen.contains(root)) {
                for (int i = 0; i < level; i++) {
                    result += "    ";
                }
                return result + root.data + "(CYCLE)" + System.lineSeparator();
            }
            seen.add(root);
            result += toStringSideways(root.right, level + 1, seen);
            for (int i = 0; i < level; i++) {
                result += "    ";
            }
            result += root.data + System.lineSeparator();
            result += toStringSideways(root.left, level + 1, seen);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntTree)) {
            return false;
        }
        return equals(this.overallRoot, ((IntTree) o).overallRoot);
    }

    private static boolean equals(IntTreeNode t1, IntTreeNode t2) {
        if (t1 == null && t2 != null) {
            return false;
        } else if (t1 != null && t2 == null) {
            return false;
        } else if ((t1 != null && t2 != null)) {
            if (t1.data != t2.data) {
                return false;
            }
            return equals(t1.left, t2.left) && equals(t1.right, t2.right);
        }
        return true;
    }


    public int hashCode() {
        return hashCode;
    }

    public static class IntTreeNode {
        public final int data;
        public IntTreeNode left;
        public IntTreeNode right;

        IntTreeNode(int data) {
            this.data = data;
        }
    }

    public Iterator<Integer> iterator() {
        return new IntTreeIterator(this.overallRoot);
    }

    private static final class IntTreeIterator implements Iterator<Integer> {
        private Deque<IntTreeNode> stack;
        private Set<IntTreeNode> seen;

        private IntTreeIterator(IntTreeNode root) {
            this.stack = new ArrayDeque<>();
            if (root != null) {
                this.stack.push(root);
                this.seen = new HashSet<>();
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            IntTreeNode next = stack.pop();
            if (seen.contains(next)) {
                throw new CycleDetectedException();
            }
            seen.add(next);
            if (next.right != null) {
                stack.push(next.right);
            }
            if (next.left != null) {
                stack.push(next.left);
            }
            return next.data;
        }
    }
}
