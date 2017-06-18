package cn.neillee.bst.serachrange;

import cn.neillee.base.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

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
    private ArrayList<Integer> list;

    /**
     * @param root: The root of the binary search tree.
     * @param k1    and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        list = new ArrayList<>();
        reverseSearch(root, k1, k2);
        // Maybe the result is not sortable that not fit the answer.
        Collections.sort(list);
        return list;
    }

    private void reverseSearch(TreeNode root, int k1, int k2) {
        if (root == null) return;
        if (root.val < k1) reverseSearch(root.right, k1, k2);
        else if (root.val >= k1 && root.val <= k2) {
            reverseSearch(root.left, k1, k2);
            reverseSearch(root.right, k1, k2);
            list.add(root.val);
        } else if (root.val > k2) {
            reverseSearch(root.left, k1, k2);
        }
    }
}