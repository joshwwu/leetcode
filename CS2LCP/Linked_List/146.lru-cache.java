import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */
class LRUCache {
    private static class DLinkedNode{
        int key, val;
        DLinkedNode pre, post;
        DLinkedNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private void addNode(DLinkedNode curr){
        curr.post = head.post;
        head.post.pre = curr;
        head.post = curr;
        curr.pre = head;
    }

    private void remove(DLinkedNode curr){
        DLinkedNode pre = curr.pre;
        DLinkedNode post = curr.post;
        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(DLinkedNode curr){
        remove(curr);
        addNode(curr);
    }

    private DLinkedNode popTail(){
        DLinkedNode tNode = tail.pre;
        tNode.pre.post = tail;
        tail.pre = tNode.pre;
        return tNode;
    }

    int capacity, count;
    DLinkedNode head, tail;
    Map<Integer, DLinkedNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        map = new HashMap<>();

        head = new DLinkedNode(-1, -1);
        head.pre = null;
        tail = new DLinkedNode(-1, -1);
        tail.post = null;
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedNode curr = map.get(key);
        if(curr == null)
            return -1;
        moveToHead(curr);
        return curr.val;
    }
    
    public void put(int key, int value) {
        DLinkedNode curr = map.get(key);
        if(curr == null){
            DLinkedNode newNode = new DLinkedNode(key, value);
            addNode(newNode);
            map.put(key, newNode);
            count++;

            if(count > capacity){
                DLinkedNode tail = popTail();
                map.remove(tail.key);
                count--;
            }
        }else{
            curr.val = value;
            moveToHead(curr);
        }
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

