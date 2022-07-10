package leetcode.dp;

/**
 * @source: https://leetcode.com/problems/min-cost-climbing-stairs/ (Min Cost Climbing Stairs)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.10 (O)
 **/
public class Q746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) return Math.min(cost[0], cost[1]);

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2;i<cost.length;i++)
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];

        return Math.min(dp[dp.length-1], dp[dp.length-2]);
    }
}
