/*
 * @lc app=leetcode id=1054 lang=java
 *
 * [1054] Distant Barcodes
 */
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes == null || barcodes.length == 0)
            return barcodes;
        int maxfre = 0, N = barcodes.length;
        int[] res = new int[N];
        int[] fre = new int[10001];
        
        for(int code: barcodes){
            fre[code]++;
            if(fre[code] > fre[maxfre])
                maxfre = code;
        }
        
        int idx = 0;
        for(int i=0; i<fre.length; i++){
            int curr = i == 0? maxfre: i;
            while(fre[curr] > 0){
                if(idx >= N)
                    idx = 1;
                res[idx] = curr;
                idx += 2;
                fre[curr]--;
            }
        }
        return res;
    }
}

