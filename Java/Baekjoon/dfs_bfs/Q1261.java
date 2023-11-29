package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1261 (알고스팟)
 * @classification: bfs
 * @문제 푼 날짜 (자력으로 풂?): 23.11.29 (O)
 **/
// todo: 0-1 bfs (최선), dijkstra (차선)으로 다시 풀어볼 것
public class Q1261 {
    final static int[] nX = {-1, 0, 1, 0};
    final static int[] nY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        int[][] brokenWallLog = new int[m][n];

        for(int i=0;i<m;i++) {
            String row = br.readLine();

            for(int j=0;j<n;j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
            }

            Arrays.fill(brokenWallLog[i], 10_000);
        }

        br.close();

        brokenWallLog[0][0] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});

        bfs(map, brokenWallLog, queue);

        System.out.print(brokenWallLog[m-1][n-1]);
    }

    private static void bfs(int[][] map, int[][] brokenWallLog, Queue<int[]> queue) {
        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            int wall1 = poll[2];

            for(int i=0;i<nX.length;i++) {
                int x2 = x1 + nX[i];
                int y2 = y1 + nY[i];
                int wall2 = wall1;

                if(x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map[0].length)
                    continue;

                if(map[x2][y2] == 1)
                    ++wall2;

                if(brokenWallLog[x2][y2] <= wall2)
                    continue;

                brokenWallLog[x2][y2] = wall2;

                queue.offer(new int[]{x2, y2, wall2});
            }
        }
    }
}
