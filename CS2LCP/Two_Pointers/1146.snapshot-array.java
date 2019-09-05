/*
 * @lc app=leetcode id=1146 lang=java
 *
 * [1146] Snapshot Array
 */
class SnapshotArray {
    ArrayList<Integer> arr = null;
    int snap_id = 0;
    HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    public SnapshotArray(int length) {
        arr = new  ArrayList<Integer>();
    }
    
    public void set(int index, int val) {
        if(arr.size() <= index){
            while(arr.size() != index){
                arr.add(0);
            }
            arr.add(index,val);    
        }else{
            arr.set(index,val);
        }
        
    }
    
    public int snap() {
        ArrayList<Integer> temp = new ArrayList<Integer>();
    	temp.addAll(arr);
        map.put(snap_id,temp);
        snap_id++;
        
        return snap_id-1;
    }
    
    public int get(int index, int snap_id) {
       ArrayList<Integer> temp =  map.get(snap_id);
        if(temp.size() > index)
            return temp.get(index);
        else 
            return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */

