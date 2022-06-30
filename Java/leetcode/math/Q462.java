package leetcode.math;

import java.util.Arrays;

/**
 * @source: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 * @classfication: math, implementation
 * @reference: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/2215782/Visual-Explanation-%2B-Interview-Tips-or-JAVA
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.30 (X)
 **/
public class Q462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int operations = 0, mid = nums[nums.length/2];
        for (int num: nums) operations += Math.abs(mid - num);
        return operations;
    }
}
