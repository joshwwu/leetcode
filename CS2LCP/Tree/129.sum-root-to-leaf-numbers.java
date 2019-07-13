/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        res = 0;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int count){
        if(root == null) return;
        count = count*10+root.val;
        if(root.left == null && root.right == null){
            res += count;
            count = (count-root.val)/10;
            return;
        }
        helper(root.left, count);
        helper(root.right, count);
        count = (count-root.val)/10;
    }
}

