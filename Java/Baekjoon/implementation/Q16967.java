package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/16967 (배열 복원하기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.01.21 (O)
 **/
public class Q16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int[][] A = new int[H][W];
        int[][] B = new int[H+X][W+Y];
        StringBuilder result = new StringBuilder();

        for(int i=0;i<H+X;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<W+Y;j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                if((i < H && j < Y) || (i < X && j < W)) {
                    A[i][j] = B[i][j];
                } else if(X <= i && i < H && Y <= j && j < W) {
                    A[i][j] = B[i][j] - A[i-X][j-Y];
                }
            }
        }

        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A[0].length;j++) {
                result.append(A[i][j]).append(' ');
            }
            result.append('\n');
        }

        System.out.print(result);
    }
}
