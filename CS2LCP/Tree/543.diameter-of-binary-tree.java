/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        maxDepth(root);
        return res-1;
    }

    private int maxDepth(TreeNode root){
        if(root == null) return 0;
        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);
        res = Math.max(res, leftD+rightD+1);
        return Math.max(leftD, rightD)+1;
    }
}

