/*
 * @lc app=leetcode id=990 lang=java
 *
 * [990] Satisfiability of Equality Equations
 */
class Solution {
    public int[] uf;
    public boolean equationsPossible(String[] equations) {
        if(equations == null || equations.length == 0)
            return false;
        uf = new int[26];
        for(int i=0; i<26; i++) uf[i] = i;
        
        for(String equ: equations)
            if(equ.charAt(1) == '=')
                uf[find(equ.charAt(3)-'a')] = find(equ.charAt(0)-'a');

        for(String equ: equations)
            if(equ.charAt(1) == '!' 
               && find(equ.charAt(3)-'a') == find(equ.charAt(0)-'a'))
                return false;
        return true;
    }
    
    private int find(int p){
        while(p != uf[p]){
            uf[p] = uf[uf[p]];
            p = uf[p];
        }
        return p;
    }
}

