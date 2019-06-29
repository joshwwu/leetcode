/*
 * @lc app=leetcode id=876 lang=java
 *
 * [876] Middle of the Linked List
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
    public ListNode middleNode(ListNode head) {
        ListNode res = head;
        while(head != null && head.next != null){
            head = head.next.next;
            res  = res.next;
        }
        return res;
    }
}

