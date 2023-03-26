package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2839 (설탕 배달)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?): 13.03.27 (O, bottom-up)
 **/
public class Q2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] memo = new int[N+1];
        memo[3] = 1;

        if(N > 4) memo[5] = 1;

        for(int i=6;i<N+1;i++) {
            int t1 = i - 3;
            int result1 = Integer.MAX_VALUE;

            if(memo[t1] != 0) result1 = memo[t1] + 1;

            int t2 = i - 5;
            int result2 = Integer.MAX_VALUE;

            if(memo[t2] != 0) result2 = memo[t2] + 1;

            int result = Math.min(result1, result2);

            memo[i] = result == Integer.MAX_VALUE ? 0 : result;
        }

        System.out.print(memo[N] == 0 ? -1 : memo[N]);
    }
}
