package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1912 (연속합)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?): 23.10.09 (O)
 **/
public class Q1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -100_000_000;

        for(int i=1;i<=N;i++) {
            int num = Integer.parseInt(st.nextToken());
            memo[i] = Math.max(num, num+memo[i-1]);
            max = Math.max(max, memo[i]);
        }

        System.out.print(max);
        br.close();
    }
}
