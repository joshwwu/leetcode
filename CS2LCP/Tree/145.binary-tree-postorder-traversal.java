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
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                res.add(0, curr.val);//add node first, but add at head's position
                curr = curr.right;//find the rightmost
            }else{
                TreeNode node = stack.pop();
                curr = node.left;//after reach the rightmost node, turn to its left sibling
            }
        }
    
        return res;
    }
}

