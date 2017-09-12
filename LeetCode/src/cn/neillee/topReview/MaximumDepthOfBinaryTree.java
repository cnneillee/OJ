package cn.neillee.topReview;

import cn.neillee.topReview.support.*;

/**
 * @author Neil
 * @date 2017/9/7.
 * @difficulity easy
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args){
        MaximumDepthOfBinaryTree thiz = new MaximumDepthOfBinaryTree();
        Solution s = thiz.new Solution();
        int res = s.maxDepth(null);
        System.out.println(res);
    }
    class Solution{
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int left = root.left==null ? 0:maxDepth(root.left);
            int right = root.right==null ? 0:maxDepth(root.right);
            return 1 + Math.max(left, right);
        }
    }
}
