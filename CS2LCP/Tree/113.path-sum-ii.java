/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(root, res, new LinkedList<>(), sum);
        return res;
    }
    
    private void backtracking(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum){
        if(root == null )
            return;
        list.add(root.val);
        if(sum == root.val && root.left == null && root.right == null){
        //add list to res when root.val == sum and root is a leaf node
            res.add(new LinkedList<>(list));
            list.remove(list.size()-1);
            return;
        }
        backtracking(root.left, res, list, sum-root.val);
        backtracking(root.right, res, list, sum-root.val);
        list.remove(list.size()-1);
    }
}

