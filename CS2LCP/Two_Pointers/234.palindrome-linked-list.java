/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, tmp = dummy;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            tmp = tmp.next;
        }
        tmp = reverseList(tmp);
        fast = head;
        while(fast != null && fast.val == tmp.val){
            fast = fast.next;
            tmp = tmp.next;
        }
        return fast == null? true: false; 
    }
    
    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy.next;
        while(curr.next != null){
            ListNode node = curr.next;
            curr.next = node.next;
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
}

