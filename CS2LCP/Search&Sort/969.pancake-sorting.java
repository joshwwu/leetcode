/*
 * @lc app=leetcode id=969 lang=java
 *
 * [969] Pancake Sorting
 */
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        
        for(int size=A.length; size>1; size--){
            
            int maxNum = A[0], maxIndex = 0;
            for(int i=0; i<size; i++){
                if(A[i] > maxNum){
                    maxNum = A[i];
                    maxIndex = i;
                }
            }
            
            reverse(A, maxIndex+1);
            res.add(maxIndex+1);
            reverse(A, size);
            res.add(size);
        }
        return res;
    }
    
    private void reverse(int[] A, int index){
        for(int i=0; i<index/2; i++){
            int temp = A[i];
            A[i] = A[index-1-i];
            A[index-1-i] = temp;
        }
    }
}

