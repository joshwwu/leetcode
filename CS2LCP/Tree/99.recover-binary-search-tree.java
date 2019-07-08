/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    TreeNode first = null, second = null, pre = null;
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        recover(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void recover(TreeNode root){
        if(root == null)
            return;
        recover(root.left);
        if(first == null && pre != null && pre.val > root.val)
            first = pre;
        if(first != null && pre != null && pre.val > root.val)
            second = root;
        pre = root;
        recover(root.right);
    }
}

