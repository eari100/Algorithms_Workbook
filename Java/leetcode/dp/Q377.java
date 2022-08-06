package leetcode.dp;

import java.util.Arrays;

/**
 * @source: https://leetcode.com/problems/combination-sum-iv/ (Combination Sum IV)
 * @classfication: dp
 * @reference: https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation (점화식 참고)
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.08.06 (X)
 **/
public class Q377 {
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }
}
