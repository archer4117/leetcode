package com.leetcode.wing;

/**
 * Definition for a binary tree node.
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

/**
 * @author qxs on 2018/7/11.
 * 树
 */
public class Tree {

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHigh = 0;
        int rightHigh = 0;
        if(root.left!=null){
            if(!isBalanced(root.left)){
                return false;
            }
            leftHigh = root.left.val+1;
        }
        if (root.right !=null){
            if(!isBalanced(root.right)){
                return false;
            }
            rightHigh = root.right.val+1;
        }
        root.val = Math.max(leftHigh,rightHigh);
        return Math.abs(leftHigh - rightHigh) <= 1;
    }


    /**
     * 返回二叉树的最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return minDepth(root.right)+1;
        }else if(root.right==null){
            return minDepth(root.left)+1;
        }else{
            return Math.min(minDepth(root.right),minDepth(root.left))+1;
        }

    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        do110(tree);
        do111(tree);
    }

    private static void do110(Tree tree) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println("110.balanced-binary-tree:"+tree.isBalanced(root));
    }

    private static void do111(Tree tree) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println("111.minimum-depth-of-binary-tree:"+tree.minDepth(root));
    }

}
