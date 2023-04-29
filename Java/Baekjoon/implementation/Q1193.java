package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/1193 (분수찾기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.29 (O)
 **/
public class Q1193 {
    final static int[] nX = {0, 1, 1, -1}; // 오른쪽, 왼쪽 아래 대각선, 아래, 오른쪽 위 대각선
    final static int[] nY = {1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        br.close();

        int x = 1;
        int y = 1;
        int nXIndex = 0;

        for(int i=2;i<X+1;i++) {
            x += nX[nXIndex];
            y += nY[nXIndex];
            if(nXIndex == 0 || nXIndex == 2) {
                ++nXIndex;
            } else if(nXIndex == 1 && y == 1) {
                ++nXIndex;
            } else if(nXIndex == 3 && x == 1) {
                nXIndex = 0;
            }
        }

        System.out.print(x + "/" + y);
    }
}
