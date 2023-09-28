package Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/11048 (이동하기)
 * @classfication: dp
 * @문제 푼 날짜 (자력으로 풂?): 23.09.28 (O)
 **/
public class Q11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int[][] prevPoints = {{-1, -1}, {-1, 0}, {0, -1}};

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] memo = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                memo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                int x1 = i, y1 = j;
                int temp = 0;

                for(int k=0;k<prevPoints.length;k++) {
                    int x2 = x1 + prevPoints[k][0];
                    int y2 = y1 + prevPoints[k][1];

                    if(x2 < 0 || y2 < 0) continue;

                    temp = Math.max(temp, memo[x2][y2]);
                }

                memo[x1][y1] += temp;
            }
        }

        System.out.print(memo[N-1][M-1]);
    }
}
