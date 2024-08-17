package Baekjoon.dp.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/7570 (줄 세우기)
 * @classification: 연속된 LIS
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.08.17 (X)
 **/
public class Q7570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        int[] dp = new int[n+1];
        int max = 0;

        for(int i=0;i<n;i++) {
            int num = Integer.parseInt(st.nextToken());

            dp[num] = dp[num-1] + 1;
            max = Math.max(max, dp[num]);
        }

        System.out.print(n - max);
    }
}



