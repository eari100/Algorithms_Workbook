package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/1913 (달팽이)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.06.06 (O), todo: 메모리를 사용해서 수행시간 줄이기, 로직 간단하게 바꾸기, 역순으로 탐색하기
 **/
public class Q1913 {
    final static int[] nX = {0, 1, 0, -1}; // 우, 하, 좌, 상
    final static int[] nY = {1, 0, -1, 0}; // 우, 하, 좌, 상

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int targetX = 0, targetY = 0;
        int maxIndex = Integer.parseInt(br.readLine());

        br.close();

        int[][] board = new int[N][N];

        int nIndex = 3;
        int x, y, frameX1, frameY1, frameX2, frameY2;
        x = y = frameX1 = frameY1 = frameX2 = frameY2 = ((N+1) / 2) - 1;
        x -= nX[nIndex];
        y -= nY[nIndex];

        for(int i=1;i<(N*N)+1;i++) {
            int tmpX = x + nX[nIndex];
            int tmpY = y + nY[nIndex];

            if(frameX1 == tmpX && frameY1 == tmpY) {
                x += nX[nIndex];
                y += nY[nIndex];
                board[x][y] = i;

                --frameX1;
                --frameY1;
                ++frameX2;
                ++frameY2;

                ++i;
                if(i<(N*N)+1) {
                    x += nX[nIndex];
                    y += nY[nIndex];
                    board[x][y] = i;
                }

                nIndex = 0;
            } else if(tmpX < frameX1 || tmpX > frameX2 || tmpY < frameY1 || tmpY > frameY2) {
                ++nIndex;

                x += nX[nIndex];
                y += nY[nIndex];
                board[x][y] = i;
            } else {
                x += nX[nIndex];
                y += nY[nIndex];
                board[x][y] = i;
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                int number = board[i][j];
                if(number == maxIndex) {
                    targetX = i;
                    targetY = j;
                }

                result.append(board[i][j]).append(' ');
            }
            result.append('\n');
        }

        result.append(targetX+1).append(' ').append(targetY+1);

        System.out.print(result);
    }
}
