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
        if(head == null)
            return true;
        ListNode fast = head, slow = head;
        int length = 0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            length++;
        }
        slow = reverse(slow); fast = head;
        for(int i=0; i<length; i++){
            if(fast.val != slow.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode next = head.next;
            head.next = newHead;            
            newHead = head;
            head = next;
        }
        return newHead;
    }
}

