/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        if(root.left != null) flatten(root.left);
        if(root.right != null) flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left  = null;
        while(root.right != null) root = root.right;
        root.right = temp;
    }
}

