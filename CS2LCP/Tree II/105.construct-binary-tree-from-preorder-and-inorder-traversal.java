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
        if(preorder == null || inorder == null || 
           preorder.length != inorder.length)
            return null;
    
        int len = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
    
        for(int i=0; i<len; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, map, 0, len-1, 0, len-1);
    }
    private TreeNode helper(int[] preorder, Map<Integer, Integer> map, int prel, int prer, int inl, int inr){
        if(prel > prer)
            return null;
        if(prel == prer)
            return new TreeNode(preorder[prel]);
    
        TreeNode root = new TreeNode(preorder[prel]);   
        int mid = map.get(preorder[prel]);
        int leftLen = mid-inl;
    
        root.left = helper(preorder, map, prel+1, prel+leftLen, inl, mid-1);
        root.right = helper(preorder, map, prel+leftLen+1, prer, mid+1, inr);
        return root;
    }
}

