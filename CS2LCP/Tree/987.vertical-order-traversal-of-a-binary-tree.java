/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
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
    class Point{
        int x, y, val;
        Point(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Point> queue = new PriorityQueue<>(1000, new Comparator<Point>(){
            public int compare(Point p1, Point p2){
                if(p1.x < p2.x) return -1;
                if(p2.x < p1.x) return 1;
                if(p1.y < p2.y) return 1;
                if(p2.y < p1.y) return -1;
                return p1.val-p2.val;
            }
        });
    
        helper(root, 0, 0, queue);
        Point pre = null;
        List<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()){
            Point curr = queue.poll();
            if(pre == null || curr.x != pre.x){
                if(pre != null) res.add(list);
                list = new LinkedList<>();
            }
            list.add(curr.val);
            pre = curr;
        }
        if(res.size() > 0) res.add(list);
        return res;
    }
    
    private void helper(TreeNode root, int x, int y, PriorityQueue<Point> queue){
        if(root == null) return;
        queue.offer(new Point(x, y, root.val));
        helper(root.left, x-1, y-1, queue);
        helper(root.right, x+1, y-1, queue);
    }
}

