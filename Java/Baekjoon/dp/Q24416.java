package Baekjoon.dp;

import java.io.*;

/**
 * @source: https://www.acmicpc.net/problem/24416
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.14 (O, 다시 확인해 보자)
 **/
public class Q24416 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        System.out.println(fibonacci(n) + " " + (n-2));
    }

    private static int fibonacci(int n) {
        int[] memo = new int[n+1];
        memo[1] = memo[2] = 1;

        for(int i=3;i<n+1;i++)
            memo[i] = memo[i-1] + memo[i-2];

        return memo[n];
    }
}
