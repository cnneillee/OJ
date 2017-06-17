package cn.neillee.bst.removenode;

import cn.neillee.base.TreeNode;

/**
 * Created by Neil on 2017/6/16.
 */
public class Solution {
    /**
     * @param root:  The root of the binary search bst.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search bst after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if(root == null) return null;
        // write your code here
        if (root.val == value) {
            if (root.left == null) root = root.right;
            else {
                TreeNode right = root.right;
                root = root.left;
                TreeNode temp = root;
                while (temp.right != null) temp = temp.right;
                temp.right = right;
            }
        }else{
            reverseBST(root, value > root.val ? root.right : root.left, value);
        }
        return root;
    }

    private void reverseBST(TreeNode parent, TreeNode node, int value) {
        if(node == null) return;
        if (node.val > value) {
            reverseBST(node, node.left, value);
        } else if (node.val < value) {
            reverseBST(node, node.right, value);
        } else if (node.val == value) {
            //do delete
            if (node.left == null && node.right == null) {
                if (parent.val > value)// 左子树中
                    parent.left = null;
                else parent.right = null;
            } else if (node.left != null) {
                if (parent.val > value) // 左子树中
                    parent.left = node.left;
                else
                    parent.right = node.left;
                if (node.right != null) {
                    TreeNode temp = node.left;
                    while (temp.right != null) temp = temp.right;
                    temp.right = node.right;
                }
            } else {
                if (parent.val > value) // 左子树中
                    parent.left = node.right;
                else
                    parent.right = node.right;
            }
        }
    }
}
