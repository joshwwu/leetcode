/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return res;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int level){
        if(root == null)
            return;
        if(level == res.size())
            res.add(new LinkedList<Integer>());
        if(level%2 == 1)
            res.get(level).add(0, root.val);//add node at head to produce zigzag
        else
            res.get(level).add(root.val);
        helper(root.left, level+1);
        helper(root.right, level+1);
    }
}

