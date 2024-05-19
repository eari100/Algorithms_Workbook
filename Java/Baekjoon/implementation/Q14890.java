package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14890 (경사로)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.05.19 (O)
 **/
public class Q14890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];


        for(int i=0;i<N;i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            board[i] = row.clone();
        }

        br.close();

        for(int i=0;i<N;i++) {
            boolean[] tmpBoard = new boolean[N];

            L1:
            for(int j=1;j<N;j++) {
                int prev = board[i][j-1];
                int curr = board[i][j];

                int abs = Math.abs(prev - curr);
                if(abs > 1) {
                    break L1;
                }

                // 1 차이
                if(prev+1 == curr) {
                    // 경사로 overflow
                    if(j-L < 0) break L1;

                    for(int k=j-1;k>=j-L;k--) {
                        // 중복 경사로
                        if(tmpBoard[k]) break L1;
                        // 경사로 땅 평탄화 x
                        if(prev != board[i][k]) break L1;
                        tmpBoard[k] = true;
                    }
                } else if(prev == curr+1) {
                    // 경사로 overflow
                    if(j+L-1 >= N) break L1;

                    for(int k=j;k<=j+L-1;k++) {
                        // 중복 경사로
                        if(tmpBoard[k]) break L1;
                        // 경사로 땅 평탄화 x
                        if(curr != board[i][k]) break L1;
                        tmpBoard[k] = true;
                    }

                    j+=(L-1);
                }

                if(j == N-1) {
                    // System.out.println(i);
                    ++result;
                }
            }
        }

        ////////////

        for(int i=0;i<N;i++) {
            boolean[] tmpBoard = new boolean[N];

            L1:
            for(int j=1;j<N;j++) {
                int prev = board[j-1][i];
                int curr = board[j][i];

                int abs = Math.abs(prev - curr);
                if(abs > 1) {
                    break L1;
                }

                // 1 차이
                if(prev+1 == curr) {
                    // 경사로 overflow
                    if(j-L < 0) break L1;

                    for(int k=j-1;k>=j-L;k--) {
                        // 중복 경사로
                        if(tmpBoard[k]) break L1;
                        // 경사로 땅 평탄화 x
                        if(prev != board[k][i]) break L1;
                        tmpBoard[k] = true;
                    }
                } else if(prev == curr+1) {
                    // 경사로 overflow
                    if(j+L-1 >= N) break L1;

                    for(int k=j;k<=j+L-1;k++) {
                        // 중복 경사로
                        if(tmpBoard[k]) break L1;
                        // 경사로 땅 평탄화 x
                        if(curr != board[k][i]) break L1;
                        tmpBoard[k] = true;
                    }

                    j+=(L-1);
                }

                if(j == N-1) {
                    //System.out.println(i);
                    ++result;
                }
            }
        }

        System.out.print(result);
   }
}
