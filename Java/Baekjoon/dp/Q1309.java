package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@source: https://www.acmicpc.net/problem/1309
 *@classfication: dp
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.12.29 (X)
 **/
public class Q1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int MOD = 9901;

        br.close();

        int[][] dp = new int[N+1][3];
        dp[0][0] = 1;

        for(int i=1;i<=N;i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        System.out.print((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);
    }
}
