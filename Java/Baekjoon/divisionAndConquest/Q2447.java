package Baekjoon.divisionAndConquest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2447 (별 찍기 - 10)
 * @classification: divide and conquest, recursion
 * @문제 푼 날짜 (자력으로 풂?): O
 **/
public class Q2447 {
    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        board = new boolean[n][n];
        solve(0, 0, n);

        StringBuilder answer = new StringBuilder();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                answer.append(board[i][j] ? '*' : ' ');
            }
            answer.append('\n');
        }

        System.out.print(answer);
    }

    private static void solve(int x, int y, int len) {
        if(len == 3) {
            for(int i=0;i<len;i++) {
                for(int j=0;j<len;j++) {
                    if(i == 1 && j == 1) continue;

                    board[x+i][y+j] = true;
                }
            }
        } else {
            int interval = len / 3;

            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    if(i == 1 && j == 1) {
                        continue;
                    }

                    solve(x+i*interval, y+j*interval, interval);
                }
            }
        }
    }
}
