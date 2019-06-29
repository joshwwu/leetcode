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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = head, pre = dummy;
        int count = 0;
        while(start != null){
            while(start.next != null && count != 1){
                ListNode curr = start.next;
                start.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
                count++;
            }
            count = 0;
            pre = start;
            start = start.next;
        }
        return dummy.next;
    }
}

