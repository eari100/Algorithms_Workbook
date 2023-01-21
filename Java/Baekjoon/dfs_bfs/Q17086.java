package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/17086 (아기 상어 2)
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.01.21 (O)
 **/
public class Q17086 {
    static int[] dx = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = new int[]{0, 0, -1, 1, -1, 1, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][M];
        int maxSafeScore = 0;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++) {
                int isShark = Integer.parseInt(st.nextToken());
                graph[i][j] = isShark;

                if(isShark == 1) queue.offer(new int[]{i, j});
            }
        }

        br.close();

        maxSafeScore = getMaxSafeZone(graph);
        System.out.print(maxSafeScore);
    }

    private static int getMaxSafeZone(int[][] graph) {
        int maxSafeScore = 0;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];

            for(int i=0;i<dx.length;i++) {
                int x2 = x1 + dx[i];
                int y2 = y1 + dy[i];

                if(x2 < 0 || x2 > graph.length - 1 || y2 < 0 || y2 > graph[0].length - 1) continue;

                if(graph[x2][y2] > 0) continue;

                graph[x2][y2] = graph[x1][y1] + 1;
                maxSafeScore = Math.max(maxSafeScore, graph[x2][y2]);
                queue.offer(new int[]{x2, y2});
            }
        }

        return maxSafeScore - 1;
    }
}
