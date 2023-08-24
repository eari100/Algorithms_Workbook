package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/10836 (여왕벌)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.24 (O)
 **/
// todo: 1차원 배열만 사용하여 풀어볼 것
public class Q10836 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[M][M];
        int day = Integer.parseInt(st.nextToken());

        int[] growths = new int[2*M-1];

        for(int i=0;i<day;i++) {
            st = new StringTokenizer(br.readLine());
            int gIdx = 0;
            for(int j=0;j<3;j++) {
                int cnt = Integer.parseInt(st.nextToken());

                for(int k=0;k<cnt;k++) {
                    growths[gIdx++] += j;
                }
            }
        }


        br.close();

        int x = M-1;
        int y = 0;

        for(int j=0;j<2*M-1;j++) {
            board[x][y] += growths[j] + 1;

            if(x > 0) {
                --x;
            } else {
                ++y;
            }
        }

        for(int j=1;j<M;j++) {
            for(int k=1;k<M;k++) {
                board[j][k] = Math.max(Math.max(board[j][k-1], board[j-1][k-1]), board[j-1][k]);
            }
        }

        StringBuilder result = new StringBuilder();

        for(int[] row : board) {
            for(int i : row) {
                result.append(i).append(' ');
            }

            result.append('\n');
        }

        System.out.print(result);
    }
}
