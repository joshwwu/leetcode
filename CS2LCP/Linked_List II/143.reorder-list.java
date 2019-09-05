/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        
        //find the start of second part
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //reverse the second part
        ListNode curr = slow.next;
        while(curr.next != null){
            ListNode fir = curr.next;
            curr.next = fir.next;
            fir.next = slow.next;
            slow.next = fir;
        }
        
        //put second part to intervls
        fast = head;
        while(fast != slow){
            ListNode next = slow.next;
            slow.next = next.next;
            next.next = fast.next;
            fast.next = next;
            fast = next.next;
        }
    }
}

