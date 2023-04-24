package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1952 (달팽이2)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.24 (O)
 **/
// todo: 수학적으로 풀어보자
public class Q1952 {
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        br.close();

        int result = 0;
        int x = 0, y = -1;
        int dXIndex = 0;
        boolean[][] visited = new boolean[M][N];

        for(int i=0;i<visited.length;i++) {
            for(int j=0;j<visited[0].length;j++) {

                if(x + dX[dXIndex] < 0 || x + dX[dXIndex] > visited.length - 1
                        || y + dY[dXIndex] < 0 || y + dY[dXIndex] > visited[0].length - 1
                        || visited[x + dX[dXIndex]][y + dY[dXIndex]]) {
                    ++dXIndex;
                    ++result;

                    if(dXIndex == dX.length) dXIndex = 0;
                }

                x += dX[dXIndex];
                y += dY[dXIndex];

                visited[x][y] = true;
            }
        }

        System.out.print(result);
    }
}
