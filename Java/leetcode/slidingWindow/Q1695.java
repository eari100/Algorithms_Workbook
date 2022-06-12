package leetcode.slidingWindow;

import java.util.HashSet;

/**
 * @source: https://leetcode.com/problems/maximum-erasure-value/
 * @classfication: sliding window
 * @reference: https://leetcode.com/problems/maximum-erasure-value/discuss/978552/Java-O(n)-Sliding-Window-%2B-HashSet
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.12 (X)
 **/
public class Q1695 {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0, subSum = 0;
        int i = 0, j = 0;

        while(i < nums.length) {
            if( !set.contains(nums[i]) ) {
                subSum += nums[i];
                set.add(nums[i++]);
            } else {
                sum = Math.max(sum, subSum);
                subSum -= nums[j];
                set.remove(nums[j++]);
            }
        }

        return Math.max(sum, subSum);
    }
}
