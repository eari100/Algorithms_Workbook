package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1245 (농장 관리)
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.11.26 (O)
 **/
// todo: dfs로 풀어볼 것
public class Q1245 {
    static final int[] nX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] nY = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] map;
    static boolean[][] visited;
    static int mountainCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++) {
                int height = Integer.parseInt(row.nextToken());

                map[i][j] = height;

                if(height == 0)
                    visited[i][j] = true;
            }
        }

        br.close();

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.print(mountainCnt);
    }

    private static void bfs(int x, int y) {
        visited[x][y] = true;
        HashSet<int[]> topMountain = new HashSet<>();
        topMountain.add(new int[]{x, y});

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];

            for(int i=0;i<nX.length;i++) {
                int x2 = x1 + nX[i];
                int y2 = y1 + nY[i];

                if(x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map[0].length)
                    continue;

                if(visited[x2][y2])
                    continue;

                if(map[x2][y2] != map[x][y])
                    continue;

                visited[x2][y2] = true;

                topMountain.add(new int[]{x2, y2});
                queue.offer(new int[]{x2, y2});
            }
        }

        for(int[] tm : topMountain) {
            int x1 = tm[0];
            int y1 = tm[1];

            for(int i=0;i<nX.length;i++) {
                int x2 = x1 + nX[i];
                int y2 = y1 + nY[i];

                if(x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map[0].length)
                    continue;

                if(map[x1][y1] < map[x2][y2])
                    return;
            }
        }

        ++mountainCnt;
    }
}
