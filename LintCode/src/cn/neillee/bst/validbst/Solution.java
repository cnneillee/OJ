package cn.neillee.bst.validbst;

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
    public long temp = Long.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode node = generateExam();
        System.out.println(new Solution().isValidBST(node));
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
     * @param root: The root of binary bst.
     * @return: True if the binary bst is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return reverseLDR(root);
    }

    /**
     * 先序遍历有序（等于也不行）
     */
    public boolean reverseLDR(TreeNode root) {
        if (root == null) return true;
        if (!reverseLDR(root.left)) return false;
        if (root.val <= temp) return false;
        temp = root.val;
        if (!reverseLDR(root.right)) return false;
        return true;
    }
}