package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2072 (오목)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.07.08 (O, 타인 반례 참고, todo: 분기가 많은 문제 추후에 업솔빙해볼 것)
 **/
public class Q2072 {
    static int[] dX = {0, 1, 1, 1};
    static int[] dY = {1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int color = -1; // -1: 흑, 1: 백
        int[][] board = new int[19][19];
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = color;

            color *= -1;

            for(int i=0;i<19;i++) {
                for(int j=0;j<19;j++) {
                    int stone = board[i][j];

                    if(stone == 1 || stone == -1) {
                        for(int k=0;k<dX.length;k++) {
                            int x2 = i;
                            int y2 = j;
                            int nX = dX[k];
                            int nY = dY[k];

                            int x6 = i+(nX*5);
                            int y6 = j+(nY*5);
                            if(x6 >= 0 && x6 < 19 && y6 >= 0 && y6 < 19) {
                                int sixStone = board[i+(nX*5)][j+(nY*5)];
                                if(stone == sixStone) continue;
                            }

                            int xR = i-nX;
                            int yR = j-nY;
                            if(xR >= 0 && xR < 19 && yR >= 0 && yR < 19) {
                                int reverseStone = board[i-nX][j-nY];
                                if(stone == reverseStone) continue;
                            }

                            for(int l=2;l<=5;l++) {
                                x2 += nX;
                                y2 += nY;

                                if(x2 < 0 || x2 >= 19 || y2 < 0 || y2 >= 19) break;

                                int nextStone = board[x2][y2];

                                if(stone != nextStone) break;

                                if(l == 5) {
                                    System.out.print(t);
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }
        }
        br.close();

        System.out.print(-1);
    }
}
