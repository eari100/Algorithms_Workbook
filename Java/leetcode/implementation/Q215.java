package leetcode.implementation;

import java.util.Arrays;

/**
 * @source: https://leetcode.com/problems/kth-largest-element-in-an-array/ (215. Kth Largest Element in an Array)
 * @classfication: priority queue, quick sort
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.22 (O, 단순 구현이 아닌 priority queue, quick sort 활용해서 풀는 게 정석)
 **/
public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
