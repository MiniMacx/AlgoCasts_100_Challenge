package algocasts.plan100.part1;

import java.util.Stack;

/**
 * No.4判断对称二叉树
 * @author Lin
 */
public class SymmetricTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归求法
     * @param a
     * @param b
     * @return
     */
    private boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a != null && b != null) {
            return a.val == b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
        }
        return a == null && b == null;
    }


    private boolean symmetricCur(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     * 使用栈完成迭代求法
     * @param root
     * @return
     */
    private boolean symmetricIter(TreeNode root) {
        if (root ==null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode a = stack.pop();
            TreeNode b = stack.pop();
            if (a == null && b==null){
                continue;
            }
            if (a == null || b==null){
                return false;
            }
            if (a.val != b.val) {
               return false;
            }
            stack.push(a.left);
            stack.push(b.right);
            stack.push(a.right);
            stack.push(b.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(new SymmetricTree().symmetricCur(root));
        System.out.println(new SymmetricTree().symmetricIter(root));
    }
}
