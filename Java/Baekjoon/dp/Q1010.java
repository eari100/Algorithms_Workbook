package Baekjoon.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1010 (다리 놓기)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.16 (O)
 **/
public class Q1010 {
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=1;i<30+1;i++) {
            for(int j=1;j<30+1;j++) {
                if(i==1) dp[i][j] = j;
                else dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();

        while(--T > -1) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(dp[N][M]).append('\n');
        }
        br.close();

        System.out.print(sb);
    }
}
