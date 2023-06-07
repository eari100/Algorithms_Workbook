package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/1347 (미로 만들기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.06.07 (O)
 **/
public class Q1347 {
    public static void main(String[] args) throws IOException {
        char[][] board = new char[200][200];
        for (char[] row : board) {
            Arrays.fill(row, '#');
        }

        int x1 = 100, y1 = 100, x2 = 100, y2 = 100, nX = 100, nY = 100;
        board[nX][nY] = '.';

        // 0: 북, 1: 동, 2: 남, 3: 서
        int direct = 2;
        final int[] dX = {-1, 0, 1, 0};
        final int[] dY = {0, 1, 0, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int behaveCnt = Integer.parseInt(br.readLine());
        String behaves = br.readLine();

        br.close();

        for(char behave : behaves.toCharArray()) {
            if(behave == 'F') {
                nX += dX[direct];
                nY += dY[direct];
                board[nX][nY] = '.';

                x1 = Math.min(x1, nX);
                y1 = Math.min(y1, nY);
                x2 = Math.max(x2, nX);
                y2 = Math.max(y2, nY);
            } else if(behave == 'R') {
                ++direct;

                if(direct == 4) {
                    direct = 0;
                }
            } else if(behave == 'L') {
                --direct;

                if(direct == -1) {
                    direct = 3;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for(int i=x1;i<=x2;i++) {
            for(int j=y1;j<=y2;j++) {
                result.append(board[i][j]);
            }
            result.append('\n');
        }

        System.out.print(result);
    }
}
