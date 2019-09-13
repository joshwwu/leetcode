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
        List<List<Integer>> res = new LinkedList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>(1000, new Comparator<Point>(){
            public int compare(Point a, Point b){
                if(a.x < b.x) return -1;
                if(b.x < a.x) return 1;
                if(a.y < b.y) return 1;
                if(b.y < a.y) return -1;
                return a.val - b.val;
            }
        });
        
        helper(pq, root, 0, 0);
        List<Integer> list = new LinkedList<>();
        Point pre = null;
        while(!pq.isEmpty()){
            Point curr = pq.poll();
            if(pre == null || pre.x != curr.x){
                if(pre != null) res.add(list);
                list = new LinkedList<>();
            }
            list.add(curr.val);
            pre = curr;
        }
        if(list.size() > 0){
            res.add(list);
        }
        return res;
    }
    private void helper(PriorityQueue<Point> pq, TreeNode root, int x, int y){
        if(root == null) return;
        pq.offer(new Point(x, y, root.val));
        helper(pq, root.left, x-1, y-1);
        helper(pq, root.right, x+1, y-1);
    }
}

