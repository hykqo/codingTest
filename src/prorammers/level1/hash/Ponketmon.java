package prorammers.level1.hash;

import java.util.HashSet;

public class Ponketmon {
    public int solution(int[] nums) {
        int n = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int size = set.size();

        if(n > size) return size;
        else return n;
    }
}
