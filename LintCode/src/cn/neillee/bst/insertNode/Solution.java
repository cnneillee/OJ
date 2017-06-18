package cn.neillee.bst.insertNode;

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
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        absoluteRoot = root;
        reverseNewTreeAndInsert(root, root, node);
        return root;
    }

    private TreeNode absoluteRoot = null;

    private void reverseNewTreeAndInsert(TreeNode parent, TreeNode root, TreeNode node) {
        if (node == null) return;
        if (root == null) {
            TreeNode nodeLeft = node.left;
            TreeNode nodeRight = node.right;
            node.left = null;
            node.right = null;
            if (parent.val > node.val) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            if(nodeLeft != null) reverseNewTreeAndInsert(absoluteRoot, absoluteRoot, nodeLeft);
            if(nodeRight != null) reverseNewTreeAndInsert(absoluteRoot, absoluteRoot, nodeRight);
        }else{
            if (node.val > root.val) {
                reverseNewTreeAndInsert(root, root.right, node);
            } else if (node.val < root.val) {
                reverseNewTreeAndInsert(root, root.left, node);
            }
        }
    }
}