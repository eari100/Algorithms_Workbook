package Baekjoon.dp;

import java.io.*;

/**
 * @source: https://www.acmicpc.net/problem/2747 (피보나치 수)
 * @classfication: dp
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.06.15 (O)
 **/
public class Q2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        System.out.print(fibonacci(n));
    }

    private static int fibonacci(int n) {
        int[] dp = new int[n+1];

        for(int i=1;i<n+1;i++) {
            if(i<3) dp[i] = 1;
            else dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
