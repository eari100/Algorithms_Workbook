package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/17070 (파이프 옮기기 1)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.08.17 (O)
 **/
public class Q17070 {
    static int answer = 0;
    static final int[] nNodeX = {0, 1, 1}; // →, ↘, ↓
    static final int[] nNodeY = {1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        StringTokenizer st;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        dfs(board, new int[]{0, 1}, 0);
        System.out.print(answer);
    }

    private static void dfs(int[][] board, int[] node, int type) {
        int x1 = node[0];
        int y1 = node[1];

        if(x1 == board.length - 1 && y1 == board[0].length - 1) {
            ++answer;
            return;
        }

        L1: for(int mov : getAvailableMovingType(type)) {
            int[][] spaces = 차지_예정인_공간(mov);

            for(int[] space : spaces) {
                int x2 = x1 + space[0];
                int y2 = y1 + space[1];

                if(x2 >= board.length || y2 >= board[0].length) {
                    continue L1;
                }

                if(board[x2][y2] == 1) {
                    continue L1;
                }
            }

            int x3 = x1 + nNodeX[mov];
            int y3 = y1 + nNodeY[mov];

            dfs(board, new int[]{x3, y3}, mov);
        }
    }

    private static int[] getAvailableMovingType(int type) {
        if(type == 0) {
            return new int[]{0, 1};
        } else if(type == 1) {
            return new int[]{0, 1, 2};
        }  else if(type == 2) {
            return new int[]{1, 2};
        }

        return new int[]{};
    }

    private static int[][] 차지_예정인_공간(int type) {
        if(type == 0) {
            return new int[][]{{nNodeX[0], nNodeY[0]}};
        } else if(type == 1) {
            return new int[][]{{nNodeX[0], nNodeY[0]},{nNodeX[1], nNodeY[1]},{nNodeX[2], nNodeY[2]}};
        }  else if(type == 2) {
            return new int[][]{{nNodeX[2], nNodeY[2]}};
        }

        return new int[][]{};
    }
}
