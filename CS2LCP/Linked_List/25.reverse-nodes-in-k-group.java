/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = head, pre = dummy;
        int count = 0, length = 0;
        while(start != null){
            length++;
            start = start.next;
        }
        start = head;

        while(start != null){
            while(start.next != null && count != k-1 && length >= k){
                ListNode curr = start.next;
                start.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
                count++;
            }
            length -= k;
            count = 0;
            pre = start;
            start = start.next;
        }
        return dummy.next;
    }
}

