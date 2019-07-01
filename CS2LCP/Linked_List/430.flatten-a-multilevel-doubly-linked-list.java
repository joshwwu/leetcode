/*
 * @lc app=leetcode id=430 lang=java
 *
 * [430] Flatten a Multilevel Doubly Linked List
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null)
            return head;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            if(curr.child != null){
                connect(curr, next);
            }
            curr = next;
        }
        return head;
    }

    private void connect(Node curr, Node next){
        curr.next = curr.child;
        curr.child.prev = curr;
        Node child = curr.child;
        Node pre = child;
        while(child != null){
            Node childnext = child.next;
            if(child.child != null){
                connect(child, childnext);
            }
            pre = child;
            child = childnext;
        }
        if(next != null){
            pre.next = next;
            next.prev = pre;
        }
        curr.child = null;
    }
}

