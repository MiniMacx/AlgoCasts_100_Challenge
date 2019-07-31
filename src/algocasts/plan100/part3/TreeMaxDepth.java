package algocasts.plan100.part3;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxDepth {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static int getMaxRecur(TreeNode node){
        if (node == null) return 0;
        return Math.max(getMaxRecur(node.left), getMaxRecur(node.right)) + 1;
    }

    private static int getMaxQueue(TreeNode node){
        if (node == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int depth = 0;
        while (!queue.isEmpty()){
            for (int i=0;i<queue.size();i++){
                TreeNode n = queue.poll();
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
            ++depth;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;
        treeNode2.right = treeNode3;
        treeNode3.right = treeNode4;
        System.out.println(getMaxQueue(treeNode0));
        System.out.println(getMaxRecur(treeNode0));
    }
}
