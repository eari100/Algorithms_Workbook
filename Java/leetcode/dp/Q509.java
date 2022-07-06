package leetcode.dp;

/**
 * @source: https://leetcode.com/problems/fibonacci-number/
 * @classfication: dynamic programming
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.06 (O)
 **/
public class Q509 {
    public int fib(int n) {
        int[] dp = new int[n+1];

        for(int i=1;i<n+1;i++) {
            if(i<3) dp[i] = 1;
            else dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
