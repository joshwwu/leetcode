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
        return helper(pre, post, 0, pre.length-1, 0, post.length-1);
    }
    
    private TreeNode helper(int[] pre, int[] post, int start1, int end1, 
                            int start2, int end2){
        if(start1 > end1)
            return null;
        if(start1 == end1)
            return new TreeNode(pre[start1]);
        int root = 0;
        for(root=start2; root<=end2; root++){//find the seperate point of left and right subtree
            if(post[root] == pre[start1+1])
                break;
        }
        TreeNode node = new TreeNode(pre[start1]);
        node.left = helper(pre, post, start1+1, start1+root-start2+1, start2, root);  
        node.right = helper(pre, post, start1+root-start2+2, end1, root+1, end2-1);
        return node;
    }
}

