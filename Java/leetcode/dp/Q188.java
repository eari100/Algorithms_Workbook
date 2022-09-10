package leetcode.dp;

/**
 * @source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * @classfication: dynamic programming
 * @referece: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/280228/Java-Solutions
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.09.10 (X)
 **/
public class Q188 {
    public int maxProfit(int k, int[] p) {
        int n = p.length;
        if(n == 0 || k == 0) return 0;
        int[][] dp = new int[k+1][n];
        for(int t=1; t <= k; t++){
            for(int d=1; d < n; d++){
                dp[t][d] = dp[t][d-1];
                for(int m=0; m < d; m++)
                    dp[t][d] = Math.max(dp[t][d], p[d]-p[m]+dp[t-1][m]);
            }
        }
        return dp[k][n-1];
    }
}
