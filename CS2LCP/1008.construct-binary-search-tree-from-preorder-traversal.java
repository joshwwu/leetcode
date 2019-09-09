/*
 * @lc app=leetcode id=1008 lang=java
 *
 * [1008] Construct Binary Search Tree from Preorder Traversal
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
    int idx = 0, N;
    public TreeNode bstFromPreorder(int[] pre) {
        N = pre.length;
        TreeNode root = buildTree(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
    private TreeNode buildTree(int[] pre, int min, int max){
        if(idx < N && pre[idx] > min && pre[idx] < max){
            TreeNode root = new TreeNode(pre[idx++]);
            root.left = buildTree(pre, min, root.val);
            root.right = buildTree(pre, root.val, max);
            return root;
        }else{
            return null;
        }
    }
}

