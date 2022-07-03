package leetcode.greedy;

/**
 * @source: https://leetcode.com/problems/wiggle-subsequence/ (Wiggle Subsequence)
 * @classfication: greedy
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.03 (X)
 **/
public class Q376 {
    public int wiggleMaxLength(int[] nums) {
        int f = 1, d = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] > nums[i-1]) f = d + 1;
            else if(nums[i] < nums[i-1]) d = f + 1;
        }

        return Math.max(f, d);
    }
}
