package cn.neillee;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreePaths {
    private List<String> res = new ArrayList<String>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode node, String temp) {
        if (node.left == null && node.right == null) {
            if (isEmpty(temp)) {
                res.add(node.val + "");
                return;
            }
            res.add(temp + "->" + node.val);
        }
        if (node.left != null) dfs(node.left, temp + (isEmpty(temp) ? "" : "->") + node.val);
        if (node.right != null) dfs(node.right, temp + (isEmpty(temp) ? "" : "->") + node.val);
    }

    private boolean isEmpty(String str) {
        return str == null || str.equals("");
    }
}