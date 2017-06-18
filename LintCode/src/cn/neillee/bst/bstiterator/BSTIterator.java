package cn.neillee.bst.bstiterator;

import cn.neillee.base.TreeNode;

import java.util.ArrayList;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * }
 */
public class BSTIterator {
    private ArrayList<TreeNode> queue;
    private int pos = -1;

    //@param root: The root of binary tree.
    public BSTIterator(TreeNode root) {
        // write your code here
        queue = new ArrayList<>();
        reverseLDR(root);
    }

    private void reverseLDR(TreeNode root) {
        if (root == null) return;
        if (root.left != null) reverseLDR(root.left);
        queue.add(root);
        if (root.right != null) reverseLDR(root.right);
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return queue.size() > 0 && pos < queue.size();
    }

    //@return: return next node
    public TreeNode next() {
        return queue.get(pos++);
    }
}