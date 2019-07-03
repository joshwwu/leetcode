import java.util.List;

/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        if(list1.size() != list2.size())
            return false;
        return list1.equals(list2);
    }

    private void dfs(TreeNode root, List<Integer> list){
        if(root != null){
            if(root.left == null && root.right == null){
                list.add(root.val);
                return;
            }
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }
}

