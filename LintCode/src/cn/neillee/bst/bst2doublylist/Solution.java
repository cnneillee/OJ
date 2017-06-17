package cn.neillee.bst.bst2doublylist;

import cn.neillee.base.DoublyListNode;
import cn.neillee.base.TreeNode;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = generateExam();
        System.out.print("先序遍历：");
        DoublyListNode.print(solution.reverseSubTreeDLR(root));
        System.out.print("\n中序遍历：");
        DoublyListNode.print(solution.reverseSubTreeLDR(root));
        System.out.print("\n后序遍历：");
        DoublyListNode.print(solution.reverseSubTreeLRD(root));
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
     * 先序遍历（DLR）
     *
     * @param root 二叉树
     * @return 链表
     */
    private DoublyListNode reverseSubTreeDLR(TreeNode root) {
        if (root == null) return null;
        DoublyListNode node = new DoublyListNode(root.val);
        if (root.left != null) {
            node.next = reverseSubTreeDLR(root.left);
            node.next.prev = node;
        }

        if (root.right != null) {
            DoublyListNode sub = reverseSubTreeDLR(root.right);
            sub.prev = node.getTail();
            sub.prev.next = sub;
        }
        return node;
    }

    /**
     * 中序遍历（LDR）
     *
     * @param root 二叉树
     * @return 链表
     */
    public DoublyListNode reverseSubTreeLDR(TreeNode root) {
        if (root == null) return null;
        DoublyListNode listNode = new DoublyListNode(root.val);
        if (root.left != null) {
            listNode.prev = reverseSubTreeLDR(root.left).getTail();
            listNode.prev.next = listNode;
        }
        if (root.right != null) {
            listNode.next = reverseSubTreeLDR(root.right);
            listNode.next.prev = listNode;
        }
        return listNode.getHead();
    }

    /**
     * 后序遍历
     *
     * @param root 二叉树
     * @return 链表
     */
    private DoublyListNode reverseSubTreeLRD(TreeNode root) {
        if (root == null) return null;
        DoublyListNode listNode = new DoublyListNode(root.val);

        if (root.right != null) {
            DoublyListNode sub = reverseSubTreeLRD(root.right);
            listNode.prev = sub.getTail();
            listNode.prev.next = listNode;
        }

        if (root.left != null) {
            listNode = listNode.getHead();
            listNode.prev = reverseSubTreeLRD(root.left).getTail();
            listNode.prev.next = listNode;
        }

        return listNode.getHead();
    }
}
