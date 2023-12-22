package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/1904 (01타일)
 * @classfication: dp
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.12.22 (O)
 **/
public class Q1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] dp = new int[N+1];

        for(int i=1;i<N+1;i++) {
            if(i <= 2) {
                dp[i] = i;
            } else {
                dp[i] = (dp[i-1] + dp[i-2]) % 15746;
            }
        }

        System.out.print(dp[N]);
    }
}
