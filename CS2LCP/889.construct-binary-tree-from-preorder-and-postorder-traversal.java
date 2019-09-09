/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre == null || post == null || pre.length != post.length)
            return null;
    
        int len = pre.length;
        Map<Integer, Integer> map = new HashMap<>();
    
        for(int i=0; i<len; i++){
            map.put(post[i], i);
        }
        return helper(pre, map, 0, len-1, 0, len-1);
    }
    private TreeNode helper(int[] pre, Map<Integer, Integer> map, int prel, int prer, int postl, int postr){
        if(prel > prer)
            return null;
        if(prel == prer)
            return new TreeNode(pre[prel]);
    
        TreeNode root = new TreeNode(pre[prel]);   
        int leftR = map.get(pre[prel+1]);
        int leftLen = leftR-postl+1;
    
        root.left = helper(pre, map, prel+1, prel+leftLen, postl, leftR);
        root.right = helper(pre, map, prel+1+leftLen, prer, leftR+1, postr-1);
        return root;
    }
}

