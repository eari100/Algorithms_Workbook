package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/10844 (쉬운 계단 수)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 24.03.10 (X, 귀찮더라도 손으로 써야 규칙이 보임)
 * @reference: https://www.youtube.com/watch?v=Rn9G6VrBKb4
 **/
public class Q10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MOD = 1_000_000_000;
        br.close();

        int[][] dp = new int[n+1][9+1];

        for(int i=1;i<=9;i++) {
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++) {
            dp[i][0] = dp[i-1][1];
            for(int j=1;j<=8;j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
            }
            dp[i][9] = dp[i-1][9-1];
        }

        int total = 0;
        for(int cnt : dp[n]) {
            total = (total + cnt) % MOD;
        }

        System.out.print(total);
    }
}
