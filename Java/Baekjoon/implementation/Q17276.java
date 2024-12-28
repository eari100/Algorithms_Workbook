package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/17276 (배열 돌리기)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.12.28 (O)
 **/
public class Q17276 {
    public static void main(String[] args) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[][] x = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++) {
                    x[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(d == 360 || d == -360 || d == 0) {
                write(result, x);
                continue;
            }

            boolean isForward = d > 0;

            int[][][] moves = new int[4][n][2];
            getMoves(moves, n, isForward);

            while(d != 0) {
                int[] temp = new int[n];

                for(int i = 0; i < n; i++) {
                    temp[i] = x[moves[0][i][0]][moves[0][i][1]];
                }

                for(int i=1;i<=3;i++) {
                    int[][] move = moves[i];
                    int[] swap = new int[n];

                    for(int j=0;j<n;j++) {
                        swap[j] = x[move[j][0]][move[j][1]];
                    }

                    for(int j=0;j<n;j++) {
                        x[move[j][0]][move[j][1]] = temp[j];
                    }

                    for(int j=0;j<n;j++) {
                        temp[j] = swap[j];
                    }
                }

                for(int j=0;j<n;j++) {
                    x[moves[0][j][0]][moves[0][j][1]] = temp[n-1-j];
                }

                d += isForward ? -45 : 45;
            }

            write(result, x);
        }

        br.close();
        System.out.print(result);
    }

    private static void getMoves(int[][][] moves, int n, boolean isForward) {
        for(int i = 0; i < n; i++) {
            moves[0][i] = new int[]{i, i};
        }

        if(isForward) {
            for(int i = 0; i < n; i++) {
                moves[1][i] = new int[]{i, n/2};
            }

            for(int i = 0; i < n; i++) {
                moves[2][i] = new int[]{i, n-1-i};
            }

            for(int i = 0; i < n; i++) {
                moves[3][i] = new int[]{n/2, n-1-i};
            }
        } else {
            for(int i = 0; i < n; i++) {
                moves[1][i] = new int[]{n/2, i};
            }

            for(int i = 0; i < n; i++) {
                moves[2][i] = new int[]{n-1-i, i};
            }

            for(int i = 0; i < n; i++) {
                moves[3][i] = new int[]{n-1-i, n/2};
            }
        }
    }

    private static void write(StringBuilder result, int[][] x) {
        for(int[] arr :  x) {
            for(int val : arr) {
                result.append(val).append(' ');
            }

            result.append('\n');
        }
    }
}
