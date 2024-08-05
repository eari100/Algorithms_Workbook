package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @source: https://www.acmicpc.net/problem/2193 (이친수)
 * @classification: dp
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.05 (X)
 **/
public class Q2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];
        dp[1] = 1;

        br.close();

        for(int i = 2; i <= n; i++){
            if(i == 2) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        System.out.println(dp[n]);
    }
}
