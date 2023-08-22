package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/11727 (2×n 타일링 2)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?): 23.08.22 (X)
 **/
public class Q11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int[] memo = new int[100_1];
        memo[1] = 1;
        memo[2] = 3;

        for(int i=3;i<=n;i++) {
            memo[i] = (memo[i-1] + (2 * memo[i-2]))  % 10_007;
        }

        System.out.print(memo[n]);
    }
}
