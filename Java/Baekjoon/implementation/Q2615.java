package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2615 (오목)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.07.01 (O, 문제 지문 꼼꼼히 읽자, break - continue 헷깔리지 말자)
 **/
public class Q2615 {
    final static int[] nX = {-1, 0, 1, 1};
    final static int[] nY = {1, 1, 1, 0};

    public static void main(String[] args) throws IOException {
        int[][] board = new int[19][19];
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean isWin = false;

        for(int i=0;i<19;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<19;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        L1: for(int i=0;i<19;i++) {
            for(int j=0;j<19;j++) {
                int team = board[i][j];

                if(team == 1 || team == 2) {
                    for(int k=0;k<nY.length;k++) {
                        int sixRockXInx1 = i + (nX[k] * 5);
                        int sixRockYInx1 = j + (nY[k] * 5);

                        if(sixRockXInx1 >= 0 && sixRockXInx1 < 19
                                && sixRockYInx1 >= 0 && sixRockYInx1 < 19
                                && team == board[sixRockXInx1][sixRockYInx1]) continue;

                        int sixRockXInx2 = i -nX[k];
                        int sixRockYInx2 = j -nY[k];

                        if(sixRockXInx2 >= 0 && sixRockXInx2 < 19
                                && sixRockYInx2 >= 0 && sixRockYInx2 < 19
                                && team == board[sixRockXInx2][sixRockYInx2]) continue;

                        int copyOfI = i;
                        int copyOfJ = j;

                        for(int l=2;l<=5;l++) {
                            copyOfI += nX[k];
                            copyOfJ += nY[k];

                            if(copyOfI < 0 || copyOfI > 18 || copyOfJ < 0 || copyOfJ > 18) break;
                            if(team != board[copyOfI][copyOfJ]) break;

                            if(l == 5) {
                                result.append(team).append('\n')
                                        .append(i+1).append(' ').append(j+1);

                                isWin = true;

                                break L1;
                            }
                        }
                    }
                }
            }
        }

        System.out.print(isWin ? result : '0');
    }
}
