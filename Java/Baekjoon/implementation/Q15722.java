package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/15722 (빙글빙글 스네일)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.11.10 (O)
 **/
// todo: 더 효율적으로 풀어보자
public class Q15722 {
    public static void main(String[] args) throws IOException {
        boolean[][] map = new boolean[2000][2000];
        int y = 1000, x = 1000;
        final int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        map[y][x] = true;
        int mi = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            int[] move = moves[mi];
            int ny = y + move[0];
            int nx = x + move[1];

            if( !map[ny][nx] ) {
                map[ny][nx] = true;
                y = ny;
                x = nx;
            } else {
                mi = (mi+3) % 4;
                y += moves[mi][0];
                x += moves[mi][1];
                map[y][x] = true;
            }

            mi = (mi+1) % 4;
        }

        br.close();

        System.out.print((x - 1000) + " " + (y - 1000));
    }
}
