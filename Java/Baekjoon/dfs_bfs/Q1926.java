package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1926
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.06.13 (O)
 **/
public class Q1926 {
    static int[][] graph;
    static boolean[][] visited;
    static int paintingCnt;
    static int biggestPaintingSize;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        paintingCnt = 0;
        biggestPaintingSize = 0;

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<m;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!visited[i][j] && graph[i][j] == 1) {
                    ++paintingCnt;
                    biggestPaintingSize = Math.max(biggestPaintingSize, bfs(i, j));
                }
            }
        }

        System.out.println(paintingCnt);
        System.out.println(biggestPaintingSize);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        int paintingSize = 1;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();

            for(int i=0;i<=3;i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if(nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length) continue;

                if(visited[nx][ny] == false && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    ++paintingSize;
                }
            }
        }

        return paintingSize;
    }
}
