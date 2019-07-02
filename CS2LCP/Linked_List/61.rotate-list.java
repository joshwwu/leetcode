/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode run = head; int len = 1;
        while(run.next != null){
            len++;
            run = run.next;
        }
        k = k%len; run.next = head;
        while(len-k > 0){
            len--;
            run = run.next;
        }
        head = run.next;
        run.next = null;
        return head;
    }
}

