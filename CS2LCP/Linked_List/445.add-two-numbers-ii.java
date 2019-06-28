/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode dummy = new ListNode(-1);
        while(!s1.empty() || !s2.empty()){
            sum /= 10;
            if(!s1.empty()) sum += s1.pop();
            if(!s2.empty()) sum += s2.pop();
            ListNode curr = new ListNode(sum%10);
            curr.next = dummy.next;
            dummy.next = curr;
        }
        if(sum/10 == 1){
            dummy.val = 1;
            return dummy;
        }else
            return dummy.next;
    }
}

