package algocasts.plan100.part2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * No.16 树的最小深度
 */
public class TreeMinDepth {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }


    private static int minDepthRecur(TreeNode node){
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        if (node.left == null) return minDepthRecur(node.right) + 1;
        if (node.right != null) return minDepthRecur(node.left) + 1;
        else return Math.min(minDepthRecur(node.left), minDepthRecur(node.right));
    }

    private static int minDepthQueue(TreeNode node){
        int cnt = 1, size;
        if (node == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()){
            size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode s = q.poll();
                if (s.left == null && s.right == null) return cnt;
                if (s.left != null) q.add(s.left);
                if (s.right != null) q.add(s.right);
            }
            ++cnt;
        }
        return cnt;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node2.right = node6;
        System.out.println(minDepthRecur(node1));
        System.out.println(minDepthQueue(node1));
    }
}
