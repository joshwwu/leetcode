/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
    
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
    
            TreeNode curr = root.right;
            //connect root's left child to root's right child's leftmost child
            //next root will be root's right child 
            while(curr.left != null){
                curr = curr.left;
            }
            curr.left = root.left;
            return root.right;
        }
        return root;
    }
}

