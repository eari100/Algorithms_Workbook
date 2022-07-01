package Baekjoon.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1965 (상자넣기)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.01 (O)
 **/
public class Q1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] boxes = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for(int i=0;i<n;i++)
            boxes[i] = Integer.parseInt(st.nextToken());

        dp[0] = 1;
        for(int i=0;i<n;i++) {
            int max = 0;
            for(int j=0;j<i;j++) {
                if(boxes[i] > boxes[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        Arrays.sort(dp);
        System.out.print(dp[n-1]);
    }
}
