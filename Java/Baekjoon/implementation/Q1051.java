package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1051 (숫자 정사각형)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.30 (O)
 **/
public class Q1051 {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int maxRow = Math.min(h, w);
        int maxSquareSize = 0;
        board = new int[h][w];

        for(int i=0;i<h;i++) {
            String row = br.readLine();

            for(int j=0;j<w;j++) {
                board[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        br.close();

        for(int i=0;i<maxRow;i++) {
            maxSquareSize = Math.max(maxSquareSize, getSquareSize(i));
        }

        System.out.print(maxSquareSize);
    }

    private static int getSquareSize(int row) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                int 꼭짓점1 = board[i][j];

                if(i+row < 0 || i+row > board.length - 1 || j+row < 0 || j+row > board[0].length - 1)
                    continue;

                int 꼭짓점2 = board[i+row][j];
                int 꼭짓점3 = board[i][j+row];
                int 꼭짓점4 = board[i+row][j+row];

                if(꼭짓점1 == 꼭짓점2 && 꼭짓점2 == 꼭짓점3 && 꼭짓점3 == 꼭짓점4)
                    return (row+1) * (row+1);
            }
        }

        return 0;
    }
}
