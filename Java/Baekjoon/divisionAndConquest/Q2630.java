package Baekjoon.divisionAndConquest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2630 (색종이 만들기)
 * @classification: 분할 정복, 재귀
 * @문제 푼 날짜 (자력으로 풂?): 23.12.15 (O)
 **/
public class Q2630 {
    static int whiteCnt = 0;
    static int blueCnt = 0;
    static final int white = 0;
    static final int blue = 1;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++) {
                int obj = Integer.parseInt(st.nextToken());
                paper[i][j] = obj;
            }
        }

        br.close();

        divide(1, 1, n);

        StringBuilder colors = new StringBuilder();
        colors.append(whiteCnt).append('\n').append(blueCnt);

        System.out.print(colors);
    }

    private static void divide(int x0, int y0, int length) {
        int color = paper[x0][y0];

        if(isSolidColor(x0, y0, length)) {

            if(color == white) {
                ++whiteCnt;
            } else if(color == blue) {
                ++blueCnt;
            }
        } else {
            int halfLength = length / 2;
            divide(x0, y0, halfLength);
            divide(x0+halfLength, y0, halfLength);
            divide(x0, y0+halfLength, halfLength);
            divide(x0+halfLength, y0+halfLength, halfLength);
        }
    }

    private static boolean isSolidColor(int x0, int y0, int length) {
        int color = paper[x0][y0];

        for(int i=x0;i<x0+length;i++) {
            for(int j=y0;j<y0+length;j++) {
                if(color != paper[i][j])
                    return false;
            }
        }

        return true;
    }
}