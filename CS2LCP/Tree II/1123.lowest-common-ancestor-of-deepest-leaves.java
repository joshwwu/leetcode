/*
 * @lc app=leetcode id=1123 lang=java
 *
 * [1123] Lowest Common Ancestor of Deepest Leaves
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
    int deepest = 0;
    TreeNode lca;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return lca;
    }
    public int helper(TreeNode node, int depth){
        deepest = Math.max(deepest, depth);
        if(node == null)
            return depth;
        int left = helper(node.left, depth+1);
        int right = helper(node.right, depth+1);
        if(deepest == left && deepest == right)
            lca = node;
        return Math.max(left, right);
    }
}

