/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        Queue<AnotatedNode> queue = new LinkedList<>();
        queue.offer(new AnotatedNode(root, 0, 0));
        int currDepth = 0, left = 0, res = 0;
        
        while(!queue.isEmpty()){
            AnotatedNode curr = queue.poll();
            if(curr.node != null){
                queue.add(new AnotatedNode(curr.node.left, curr.depth+1, curr.pos*2));
                queue.add(new AnotatedNode(curr.node.right, curr.depth+1, curr.pos*2+1));
                if(currDepth != curr.depth){
                    currDepth = curr.depth;
                    left = curr.pos;
                }
                res = curr.pos-left+1 > res? curr.pos-left+1: res;
            }
        }
        return res;
    }
    
    class AnotatedNode{
        TreeNode node;
        int depth, pos;
        AnotatedNode(TreeNode node, int depth, int pos){
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }
    }
}

