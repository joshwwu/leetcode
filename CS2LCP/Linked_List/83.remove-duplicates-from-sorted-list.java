/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode curr = head;
        while(curr != null){
            while(curr.next != null && curr.next.val == curr.val)
                curr.next = curr.next.next;
            curr = curr.next;
        }
        return head;
    }
}

