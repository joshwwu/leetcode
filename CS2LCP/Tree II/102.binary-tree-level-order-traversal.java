/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
    
        while(queue.size() > 0){
            int len = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i=0; i<len; i++){
                TreeNode curr = queue.poll();
                list.add(curr.val); 
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            res.add(list);
        }
        return res;
    }
}

