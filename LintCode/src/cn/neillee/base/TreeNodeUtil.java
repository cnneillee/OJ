package cn.neillee.base;

/**
 * Created by Neil on 2017/6/16.
 */
public class TreeNodeUtil {
    public static void main(String[] args) {
        generateTreeNode("4", "2", "5", "1", "3");
    }

    public static TreeNode generateTreeNode(String... args) {
        if (args == null || args.length <= 0) return null;
        TreeNode root = null;
        TreeNode temp = null;
        int flag = 0;
        for (String arg : args) {
            if ("#".equals(arg)) {
                flag = flag == 1 ? 0 : 1;
            } else {
                int num = Integer.valueOf(arg);
                if (root == null) {
                    root = new TreeNode(num);
                    temp = root;
                    continue;
                }
                if (flag == 0) {
                    temp.left = new TreeNode(num);
                    flag = 1;
                } else {
                    temp.right = new TreeNode(num);
                    flag = 0;
                    temp = temp.left == null ? temp.right : temp.left;
                }
            }
        }
        return root;
    }
}
