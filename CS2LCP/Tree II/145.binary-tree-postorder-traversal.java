/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        //not need of pushing root to the stack right here
        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                res.add(0, curr.val);
                curr = curr.right;
            }else{
                TreeNode node = stack.pop();
                curr = node.left;
            }
        }
        return res;
    }
}

