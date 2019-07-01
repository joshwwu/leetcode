/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null)
            return head;
        int count = 1;
        ListNode dummy = new ListNode(-1);         
        dummy.next = head;
        ListNode pre = dummy;

        while(count != n){
            if(count == m){
                ListNode start = pre.next;
                while(start.next != null && count != n){
                    ListNode curr = start.next;
                    start.next = curr.next;
                    curr.next = pre.next;
                    pre.next = curr;
                    count++;
                }
            }else{
                count++;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}

