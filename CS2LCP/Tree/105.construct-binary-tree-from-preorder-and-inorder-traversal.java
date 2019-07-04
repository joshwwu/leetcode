/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1, 
            0, inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, 
        int start1, int end1, int start2, int end2){
        if(start1 > end1) return null;
        if(start1 == end1) return new TreeNode(preorder[start1]);
        int root = 0;
        for(root=start2; root<=end2; root++){
            if(inorder[root] == preorder[start1]){
                break;
            }
        }
        TreeNode left = helper(preorder, inorder, start1+1, start1+root-start2, 
            start2, root-1);
        TreeNode right = helper(preorder, inorder, start1+root-start2+1, end1, 
            root+1, end2);
        TreeNode node = new TreeNode(preorder[start1]);
        node.left = left; node.right = right;
        return node;
    }
}

