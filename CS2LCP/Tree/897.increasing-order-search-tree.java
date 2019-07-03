import java.util.Stack;

/*
 * @lc app=leetcode id=897 lang=java
 *
 * [897] Increasing Order Search Tree
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
    TreeNode dummy = new TreeNode(-1), curr = dummy;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null)
            return root;
        increasingBST(root.left);
        curr.right = new TreeNode(root.val);
        curr = curr.right;
        increasingBST(root.right);
        return dummy.right;
    }
}

