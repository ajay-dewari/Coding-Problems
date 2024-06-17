package miscellaneous.tree;

public class Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 226. {@link <a href="https://leetcode.com/problems/invert-binary-tree/">Invert Binary Tree</a>}
     * Given the root of a binary miscellaneous.tree, invert the miscellaneous.tree, and return its root.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: root = [4,2,7,1,3,6,9]
     * Output: [4,7,2,9,6,3,1]
     * Example 2:
     * <p>
     * <p>
     * Input: root = [2,1,3]
     * Output: [2,3,1]
     * Example 3:
     * <p>
     * Input: root = []
     * Output: []
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the miscellaneous.tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    /**
     * 104. {@link <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Maximum Depth of Binary Tree</a>}
     * Given the root of a binary miscellaneous.tree, return its maximum depth.
     * <p>
     * A binary miscellaneous.tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * <p>
     * Example 1:
     * <p>
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 3
     * Example 2:
     * <p>
     * Input: root = [1,null,2]
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the miscellaneous.tree is in the range [0, 104].
     * -100 <= Node.val <= 100
     **/
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 543. {@link <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">Diameter of Binary Tree</a>}
     * Given the root of a binary miscellaneous.tree, return the length of the diameter of the miscellaneous.tree.
     * <p>
     * The diameter of a binary miscellaneous.tree is the length of the longest path between any two nodes in a miscellaneous.tree. This path may or may not pass through the root.
     * <p>
     * The length of a path between two nodes is represented by the number of edges between them.
     * <p>
     * Example 1:
     * Input: root = [1,2,3,4,5]
     * Output: 3
     * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
     * <p>
     * Example 2:
     * Input: root = [1,2]
     * Output: 1
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the miscellaneous.tree is in the range [1, 104].
     * -100 <= Node.val <= 100
     * <p>
     **/
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int rootDiameter = maxDepth(root.left) + maxDepth(root.right);
        return Math.max(leftDiameter, Math.max(rightDiameter, rootDiameter));
    }


    /**
     * 235. {@link <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">Lowest Common Ancestor of a Binary Search Tree</a>}
     * Given a binary search miscellaneous.tree (BST), find the lowest miscellaneous.common ancestor (LCA) node of two given nodes in the BST.
     * <p>
     * According to the definition of LCA on Wikipedia: “The lowest miscellaneous.common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * <p>
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     * Example 2:
     * <p>
     * <p>
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
     * Example 3:
     * <p>
     * Input: root = [2,1], p = 2, q = 1
     * Output: 2
     * <p>
     * <p>
     * Constraints:
     * <p>
     * The number of nodes in the miscellaneous.tree is in the range [2, 105].
     * -109 <= Node.val <= 109
     * All Node.val are unique.
     * p != q
     * p and q will exist in the BST.
     * <p>
     **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);

        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
