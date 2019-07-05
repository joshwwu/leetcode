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
        TreeNode curr = root;
        queue.offer(root);
        int length = queue.size();
    
        while(length != 0){
            List<Integer> list = new LinkedList<>();
            while(length > 0){
                curr = queue.remove();
                list.add(curr.val);
                if(curr.left != null)
                    queue.offer(curr.left);
                if(curr.right != null)
                    queue.offer(curr.right);
                length--;
            }
            res.add(list);
            length = queue.size();//limit number of nodes in each level
        }
    
        return res;
    }
}

