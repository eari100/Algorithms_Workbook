package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1018 (체스판 다시 칠하기)
 * @classfication: brute-force, implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.28 (O)
 **/
public class Q1018 {
    static char[] chessRowType1 = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};
    static char[] chessRowType2 = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int minPaintCntType1 = Integer.MAX_VALUE;
        int minPaintCntType2 = Integer.MAX_VALUE;
        int paintCntType1 = 0;
        int paintCntType2 = 0;

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[][] board = new char[h][w];

        for(int i=0;i<h;i++) {
            String row = br.readLine();
            for(int j=0;j<w;j++) {
                board[i][j] = row.charAt(j);
            }
        }

        br.close();

        for(int k=0;k<=h-8;k++) {
            for(int l=0;l<=w-8;l++) {

                for(int i=0;i<8;i++) {
                    for(int j=0;j<8;j++) {
                        char obj = board[k+i][l+j];

                        if(i % 2 == 0) {
                            if(obj == chessRowType1[j]) {
                                ++paintCntType1;
                            }
                            if(obj == chessRowType2[j]) {
                                ++paintCntType2;
                            }
                        } else {
                            if(obj == chessRowType2[j]) {
                                ++paintCntType1;
                            }
                            if(obj == chessRowType1[j]) {
                                ++paintCntType2;
                            }
                        }
                    }
                }

                minPaintCntType1 = Math.min(minPaintCntType1, paintCntType1);
                minPaintCntType2 = Math.min(minPaintCntType2, paintCntType2);
                paintCntType1 = paintCntType2 = 0;
            }
        }

        System.out.print(Math.min(minPaintCntType1, minPaintCntType2));
    }
}
