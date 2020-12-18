package com.huhusw;

import java.util.HashSet;
import java.util.Set;

public class S217 {
    public static void main(String[] args) {
        S217 s217 = new S217();
        boolean b = s217.containsDuplicate(new int[]{1, 2, 3, 1});
    }
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length==0){
            return false;
        }
        Set<Integer>set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
