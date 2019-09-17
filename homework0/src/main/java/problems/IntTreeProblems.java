package problems;

import datastructures.IntTree;

// IntelliJ will complain that this is an unused import, but you should use `IntTreeNode` variables
// in your solution, and then this error should go away.
import datastructures.IntTree.IntTreeNode;

/**
 * Parts b.ix, through b.xi should go here.
 *
 * (Implement `depthSum`, `removeLeaves`, and `trim` as described by the spec.
 * See the spec on the website for picture examples and more explanation!)
 *
 * Also note: you may want to use private helper methods to help you solve these problems.
 * YOU MUST MAKE THE PRIVATE HELPER METHODS STATIC, or else your code will not compile.
 * This happens for reasons that aren't the focus of this assignment and are mostly skimmed over in
 * 142 and 143. If you want to know more, you can ask on the discussion board or at office hours.
 *
 * REMEMBER THE FOLLOWING RESTRICTIONS:
 * - do not construct new `IntTreeNode` objects (though you may have as many `IntTreeNode` variables
 *      as you like).
 * - do not call any `IntTree` methods
 * - do not construct any external data structures like arrays, queues, lists, etc.
 * - do not mutate the `data` field of any nodes (the `data` field of `IntTreeNode` is final, so you
 *      cannot if you try)
 */

public class IntTreeProblems {

    //calls private method that helps update and returns the the sum of the values stored in
    //a binary tree of integers weighted by the depth of each value
    public static int depthSum(IntTree tree) {
        return depthSum(tree.overallRoot, 1);
    }
    private static int depthSum(IntTreeNode root, int level) {
        if (root == null) { //if root is null don't add anything (empty/null case)
            return 0;
        }
        return (root.data * level) + depthSum(root.left, level + 1) + depthSum(root.right, level + 1);
    }

    //calls private method that returns updated overallRoot which removes all leaves (empty right and left subtrees)
    public static void removeLeaves(IntTree tree) {
        tree.overallRoot = removeLeaves(tree.overallRoot);
    }
    private static IntTreeNode removeLeaves(IntTreeNode root) {
        if (root == null) { //empty case if null return null
            return null;
        }
        if (root.left == null && root.right == null) { //expected case if left and right = null, root is gone
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root; //returns the root
    }

    //calls private method that returns overallRoot which removes any nodes that's value is not within [min, max]
    public static void trim(IntTree tree, int min, int max) {
        tree.overallRoot = trim(tree.overallRoot, min, max);
    }
    private static IntTreeNode trim(IntTreeNode root, int min, int max) { //private method
        if (root == null) {//empty case
            return null;
        }
        if (root.data < min) {
            return trim(root.right, min, max);
        }
        if (root.data > max) {
            return trim(root.left, min, max);
        }
        //else keep going through the tree
        root.left = trim(root.left, min, max);
        root.right = trim(root.right, min, max);
        return root;
    }
}
