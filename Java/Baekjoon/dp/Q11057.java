package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@source: https://www.acmicpc.net/problem/11057 (오르막 수)
 *@classfication: dp
 **/
public class Q11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[][] dp = new int[N+1][10+1];

        for(int i=1;i<=10;i++)
            dp[1][i] = 1;

        for(int i=2;i<=N+1;i++)
            for(int j=1;j<10+1;j++)
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10007; // overflow 방지를 위해 나눔

        int result = 0;
        for(int i=1;i<10+1;i++)
            result += dp[N][i];

        System.out.println(result % 10007);
    }
}
