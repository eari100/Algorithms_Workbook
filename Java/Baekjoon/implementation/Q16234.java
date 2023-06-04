package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/16234 (인구 이동)
 * @classfication: implementation, bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.05.01 (O)
 **/
// todo: 유니온 파인드로 속도 개선을 가능하다고 한다.
public class Q16234 {
    final static int[] nX = {-1, 1, 0, 0};
    final static int[] nY = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;
    static boolean 인구이동여부;
    static int min;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        int 인구이동일수 = 0;

        board = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        while(true) {
            인구이동여부 = false;
            visited = new boolean[N][N];

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    process(i, j);
                }
            }

            if(!인구이동여부) break;
            ++인구이동일수;
        }

        System.out.print(인구이동일수);
    }

    private static void process(int x, int y) {
        if(visited[x][y]) return;
        visited[x][y] = true;

        ArrayList<int[]> collectors = new ArrayList<>();
        int 인구수_총합 = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        collectors.add(new int[]{x, y});
        인구수_총합 += board[x][y];

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();

            for(int i=0;i<nX.length;i++) {
                int x2 = poll[0] + nX[i];
                int y2 = poll[1] + nY[i];

                if(x2 < 0 || x2 > board.length - 1 || y2 < 0 || y2 > board[0].length - 1)
                    continue;

                if(visited[x2][y2])
                    continue;

                int 인구수_차이 = Math.abs(board[poll[0]][poll[1]] - board[x2][y2]);
                if(인구수_차이 < min || 인구수_차이 > max) continue;

                visited[x2][y2] = true;
                인구이동여부 = true;
                queue.offer(new int[]{x2, y2});
                collectors.add(new int[]{x2, y2});
                인구수_총합 += board[x2][y2];
            }
        }

        int 인구수_평균 = 인구수_총합 / collectors.size();
        for(int[] arr : collectors) {
            board[arr[0]][arr[1]] = 인구수_평균;
        }
    }
}
