package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14940 (쉬운 최단거리)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.11.28 (기본적인 bfs 문제이나 특수한 조건 때문에 다시 풀어보는 것도 좋을 듯)
 **/
public class Q14940 {
    static final int[] nX = {-1, 0, 1, 0};
    static final int[] nY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<m;j++) {
                int obj = Integer.parseInt(st.nextToken());

                if(obj == 2) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }

                map[i][j] = obj;
            }
        }

        br.close();

        bfs(map, dist, visited, queue);

        for(int i=0;i<dist.length;i++) {
            for(int j=0;j<dist[0].length;j++) {
                if( map[i][j] == 1 && !visited[i][j] ) {
                    result.append(-1).append(' ');
                } else {
                    result.append(dist[i][j]).append(' ');
                }
            }
            result.append('\n');
        }

        System.out.print(result);
    }

    private static void bfs(int[][] map, int[][] dist, boolean[][] visited, Queue<int[]> queue) {
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

                visited[x2][y2] = true;

                if(map[x2][y2] != 1)
                    continue;

                if(dist[x2][y2] > 0)
                    continue;

                dist[x2][y2] = dist[x1][y1] + 1;
                queue.offer(new int[]{x2, y2});
            }
        }
    }
}
