package algocasts.plan100.part1;

/**
 * No.8 判断二叉树是否相同
 * @author Lin
 */
public class TheSameTree {

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static boolean isSymmetric(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a!=null && b !=null){
            return a.val == b.val
                    && (isSymmetric(a.left, b.left) && isSymmetric(a.right, b.right));
        }
        return false;
    }

    private static boolean judge(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        return isSymmetric(a, b);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);
        node1.left = new TreeNode(1);
        node1.left.left = new TreeNode(2);
        node1.right = new TreeNode(3);

        node5.left = new TreeNode(1);
        node5.left.left = new TreeNode(2);
        node5.right = new TreeNode(3);
        System.out.println(judge(node1, node5));
    }
}
