package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/9465 (스티커)
 * @classification: dp
 * @문제 푼 날짜 (혼자 힘으로 풂?): 24.06.30 (O)
 **/
public class Q9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] value = new int[2][n];
            int[][] memo = new int[2][n];

            for(int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++) {
                    value[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<n;i++) {
                if(i == 0) {
                    memo[0][i] = value[0][i];
                    memo[1][i] = value[1][i];
                } else if(i == 1) {
                    memo[0][i] = value[0][i] + memo[1][i-1];
                    memo[1][i] = value[1][i] + memo[0][i-1];
                } else {
                    memo[0][i] = value[0][i] + Math.max(memo[1][i-1], memo[1][i-2]);
                    memo[1][i] = value[1][i] + Math.max(memo[0][i-1], memo[0][i-2]);
                }
            }

            result.append(Math.max(memo[0][n-1], memo[1][n-1])).append('\n');
        }

        br.close();

        System.out.print(result);
    }
}
