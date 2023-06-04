package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14500 (테트로미노)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.05.20 (X, visited & getValuesUsingBt 최적화 실패)
 **/
public class Q14500 {
    final static int[] upDirection = {-1, 0};
    final static int[] downDirection = {1, 0};
    final static int[] leftDirection = {0, -1};
    final static int[] rightDirection = {0, 1};
    final static int[][] directions = { upDirection, downDirection, leftDirection, rightDirection};
    // ㅗ ㅜ ㅓ ㅏ
    final static int[][][] fuckYouShapes = {
            { leftDirection, upDirection, rightDirection },
            { leftDirection, downDirection, rightDirection },
            { leftDirection, upDirection, downDirection },
            { upDirection, rightDirection, downDirection },
    };
    static int[][] board;
    static boolean[][] visited;
    static int maxValue = 0;
    final static int maxSearchCnt = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        for(int x=0;x<N;x++) {
            for(int y=0;y<M;y++) {
                getFuckYouShapeValue(x, y, visited);
                visited[x][y] = true;
                getValuesUsingBt(0, 0, x, y, visited);
                visited[x][y] = false;
            }
        }

        System.out.print(maxValue);
    }

    private static void getFuckYouShapeValue(int x, int y, boolean[][] visited) {
        for(int[][] fuckYouShape : fuckYouShapes) {
            int value = board[x][y];

            for(int[] fuckYouNode : fuckYouShape) {
                int node1 = x + fuckYouNode[0], node2 = y + fuckYouNode[1];
                if( !validate(node1, node2, visited) ) break;

                value += board[node1][node2];
            }

            getMaxValue(value);
        }
    }

    private static void getValuesUsingBt(int searchCnt, int value, int x, int y, boolean[][] visited) {
        if(searchCnt == maxSearchCnt) {
            getMaxValue(value);
            return;
        }

        for(int i=0;i<directions.length;i++) {
            int x2 = x + directions[i][0];
            int y2 = y + directions[i][1];

            if( !validate(x2, y2, visited) ) continue;

            visited[x][y] = true;
            getValuesUsingBt(searchCnt+1, value + board[x][y], x2, y2, visited);
            visited[x][y] = false;
        }
    }

    private static boolean validate(int x, int y, boolean[][] visited) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if(visited[x][y]) return false;

        return true;
    }

    private static void getMaxValue(int value) {
        maxValue = Math.max(maxValue, value);
    }
}
