/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int leftHt = 0;
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
            leftHt++;
        }
        node = root;
        int rightHt = 0;
        while (node.right != null) {
            node = node.right;
            rightHt++;
        }
        if(leftHt == rightHt)
            return (1<<(leftHt+1))-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}

