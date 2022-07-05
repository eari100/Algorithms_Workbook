package leetcode.implementation;

import java.util.Arrays;

/**
 * @source: https://leetcode.com/problems/longest-consecutive-sequence/ (128. Longest Consecutive Sequence)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.05 (O, Runtime: 21 ms, faster than 89.78%, Memory Usage: 63.7 MB, less than 78.53%)
 **/
public class Q128 {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;
        int prev = 0;
        int len = 0;

        if(nums.length > 0) {
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            prev = nums[0];
            len = 1;
        }

        for(int i=1;i<nums.length;i++) {
            if(prev+1 == nums[i]) {
                ++len;
                prev = nums[i];
            } else if(prev > nums[i] || prev+1 < nums[i]) {
                maxLen = Math.max(maxLen, len);
                prev = nums[i];
                len = 1;
            }
        }

        return Math.max(maxLen, len);
    }
}
