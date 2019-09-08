/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
    
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        if(l1.size() != l2.size())
            return false;
        return l1.equals(l2);
    }
    
    void dfs(TreeNode root, List<Integer> l){
        if(root != null){
            if(root.left == null && root.right == null){
                l.add(root.val);
                return;
            }
            dfs(root.left, l);
            dfs(root.right, l);
        }
    }
    
}

