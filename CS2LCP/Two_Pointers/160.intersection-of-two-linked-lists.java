/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null)
            return headA;
        if(headA == null || headB == null)
            return null;
        ListNode pa = headA, pb = headB;
        while(pa != pb){
            pa = pa == null? headB: pa.next;
            pb = pb == null? headA: pb.next;
        }
        return pa;
    }
}

