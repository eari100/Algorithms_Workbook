package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/9461 (파도반 수열)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?): 23.12.10 (O, 힌트 사용)
 **/
public class Q9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        long[] dp = new long[100+1];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        for(int i=6;i<=100;i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        for(int i=0;i<t;i++) {
            int index = Integer.parseInt(br.readLine());
            result.append(dp[index]).append('\n');
        }

        br.close();
        System.out.print(result);
    }
}
