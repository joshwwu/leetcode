/*
 * @lc app=leetcode id=707 lang=java
 *
 * [707] Design Linked List
 */
class MyLinkedList {

    ListNode dummy, tail;
    int length;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        dummy = new ListNode(-1);
        tail = dummy;
        length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= length)
            return -1;
        ListNode curr = dummy;
        while(index >= 0){
            curr = curr.next;
            index--;
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = dummy.next;
        dummy.next = node;
        length++;
        if(tail.next != null){
            tail = tail.next;
        }
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
        length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length){
            return;
        }
        ListNode curr = dummy;
        while(index > 0){
            curr = curr.next;
            index--;
        }
        ListNode node = new ListNode(val);
        node.next = curr.next;
        curr.next = node;
        length++;
        if(tail.next != null){
            tail = tail.next;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length){
            return;
        }
        ListNode curr = dummy;
        while(index > 0){
            curr = curr.next;
            index--;
        }
        if(curr.next == tail)
            tail = curr;
        curr.next = curr.next.next;
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

