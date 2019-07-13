/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
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
public class Codec {

     // Encodes a tree to a single string.
     public String serialize(TreeNode root) {
        StringBuilder strb = new StringBuilder();
        buildString(root, strb);
        return strb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder strb){
        if(root == null)
            strb.append("#,");
        else{
            strb.append(root.val+",");
            buildString(root.left, strb);
            buildString(root.right, strb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }
    
    private TreeNode buildTree(Deque<String> queue){
        String str = queue.remove();
        if("#".equals(str)){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.valueOf(str));
            node.left = buildTree(queue);
            node.right= buildTree(queue);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

