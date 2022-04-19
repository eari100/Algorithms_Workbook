package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/11052 (카드 구매하기)
 *@classfication: dp
 **/
public class Q11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N+1];

        for(int i=1;i<=N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        br.close();

        int[] dp = new int[N+1];

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=i;j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
            }
        }

        System.out.print(dp[N]);
    }
}
