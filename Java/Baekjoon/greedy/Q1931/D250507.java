package Baekjoon.greedy.Q1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1931 (회의실 배정)
 * @classification: greedy
 * @문제 푼 날짜 (자력으로 풂?): 25.05.07 (O)
 **/
public class D250507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][2];
        StringTokenizer st;
        Stack<int[]> stack = new Stack<>();

        for(int a = 0; a < n; a++) {
            st = new StringTokenizer(br.readLine());
            dp[a][0] = Integer.parseInt(st.nextToken());
            dp[a][1] = Integer.parseInt(st.nextToken());
        }

        br.close();

        Arrays.sort(dp, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        stack.push(dp[0]);

        for(int i = 1; i < dp.length; i++) {
            int[] prev = stack.peek();

            if(prev[1] <= dp[i][0]) {
                System.out.println(dp[i][0] +", "+dp[i][1]);
                stack.push(dp[i]);
            }
        }

        System.out.print(stack.size());
    }
}
