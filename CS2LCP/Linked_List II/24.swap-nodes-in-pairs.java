/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0), curr = dummy;
        dummy.next = head;
        while(curr != null && curr.next != null){
            curr = helper(curr);
        }
        return dummy.next;
    }
    
    ListNode helper(ListNode node){
        ListNode fir = node.next;
        if(fir.next == null) return fir;
        ListNode sec = fir.next;
        
        fir.next = sec.next;
        sec.next = node.next;
        node.next = sec;
        
        return fir;
    }
}

