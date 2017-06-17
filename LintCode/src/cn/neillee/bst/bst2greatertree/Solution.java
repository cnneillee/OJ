package cn.neillee.bst.bst2greatertree;

import cn.neillee.base.TreeNode;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode tree = generateExam();
        new Solution().convertBST(tree);
    }

    /**
     * ### 4
     * ###/ \
     * ##2   5
     * #/ \
     * 1  3
     */
    private static TreeNode generateExam() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        return root;
    }

    /**
     * @param root the root of binary bst
     * @return the new root
     */
    public TreeNode convertBST(TreeNode root) {
        // Write your code here
        reverseRDL(root);
        return root;
    }

    private int sum = 0;

    public void reverseRDL(TreeNode root) {
        if (root == null) return;
        reverseRDL(root.right);

        root.val += sum;
        sum = root.val;
        reverseRDL(root.left);
    }
}