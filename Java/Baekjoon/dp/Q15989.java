package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/15989 (1, 2, 3 더하기 4)
 * @classification: dp
 * @문제 푼 날짜 (자력으로 풂?): 23.10.14 (X)
 **/
public class Q15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for(int i=0;i<T;i++) {
            int num = Integer.parseInt(br.readLine());
            int[][] memo = new int[Math.max(num+1, 3+1)][3+1];

            memo[1][1] = 1;

            memo[2][1] = 1;
            memo[2][2] = 1;

            memo[3][1] = 1;
            memo[3][2] = 1;
            memo[3][3] = 1;

            for(int j=4;j<=num;j++) {
                memo[j][1] = memo[j-1][1];
                memo[j][2] = memo[j-2][1] + memo[j-2][2];
                memo[j][3] = memo[j-3][1] + memo[j-3][2] + memo[j-3][3];
            }

            result.append(memo[num][1] + memo[num][2] + memo[num][3]).append('\n');
        }

        System.out.print(result);
        br.close();
    }
}
