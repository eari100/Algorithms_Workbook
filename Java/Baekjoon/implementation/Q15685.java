package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/15685 (드래곤 커브)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.05.21 (O)
 **/
public class Q15685 {
    final static int[] nX = {1, 0, -1, 0};
    final static int[] nY = {0, -1, 0, 1};
    static boolean[][] board = new boolean[101][101];
    static int squareCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 0 - 우 , 1 - 상, 2 - 좌, 3 - 하
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            processDragonCurve(x, y, d, g);
        }

        br.close();

        findSquareCnt();

        System.out.print(squareCnt);
    }

    private static void processDragonCurve(int x, int y, int d, int g) {
        List<Integer> dragonCurveDirections = new ArrayList<>();
        dragonCurveDirections.add(d);
        board[x][y] = true;

        for(int i=1;i<g+1;i++) {
            dragonCurveDirections = addNextGenerationDirectionsToDragonCurveDirections(dragonCurveDirections);
        }

        drawDragonCurveOnBoard(x, y, dragonCurveDirections);
    }

    private static void drawDragonCurveOnBoard(int x, int y, List<Integer> dragonCurveDirections) {
        for(int directions : dragonCurveDirections) {
            x += nX[directions];
            y += nY[directions];
            board[x][y] = true;
        }
    }

    private static List<Integer> addNextGenerationDirectionsToDragonCurveDirections(List<Integer> dragonCurveDirections) {
        int size = dragonCurveDirections.size();

        for(int i=size-1;i>-1;i--) {
            int direction = dragonCurveDirections.get(i);
            dragonCurveDirections.add(방향을_반시계방향으로_90도_회전(direction));
        }

        return dragonCurveDirections;
    }
    private static int 방향을_반시계방향으로_90도_회전(int d1) {
        int d2 = d1 + 1;
        if(d2 == 4) d2 = 0;

        return d2;
    }

    private static void findSquareCnt() {
        for(int i=0;i<board.length-1;i++) {
            for(int j=0;j<board[0].length-1;j++) {
                if(board[i][j] == true && board[i][j+1] == true && board[i+1][j] == true && board[i+1][j+1] == true)
                     ++squareCnt;
            }
        }
    }
}
