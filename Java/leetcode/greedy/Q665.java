package leetcode.greedy;

/**
 * @source: https://leetcode.com/problems/non-decreasing-array/discuss/2193084/Visual-Explanation-or-JAVA-Greedy (665. Non-decreasing Array)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.25 (X)
 **/
public class Q665 {
    public boolean checkPossibility(int[] nums) {
        for(int i=1, modified=0; i<nums.length; i++) {
            if(nums[i-1] > nums[i]) {
                if(modified++ == 1) return false;
                if(i<2 || nums[i-2] <= nums[i]) nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
        }
        return true;
    }
}
