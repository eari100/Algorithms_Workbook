package Baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1261 (알고스팟)
 * @classification: dijkstra
 * @문제 푼 날짜 (자력으로 풂?): 23.12.01 (O)
 **/
public class Q1261 {
    final static int[] nX = {-1, 0, 1, 0};
    final static int[] nY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        int[][] dist = new int[m][n];

        for(int[] arr : dist)
            Arrays.fill(arr, 10_000);

        for(int i=0;i<m;i++) {
            String row = br.readLine();

            for(int j=0;j<n;j++) {
                map[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        br.close();

        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((pq1, pq2) -> pq1[2] - pq2[2]);
        pq.offer(new int[]{0, 0, 0});

        dijkstra(map, dist, pq);

        System.out.print(dist[m-1][n-1]);
    }

    private static void dijkstra(int[][] map, int[][] dist, PriorityQueue<int[]> pq) {
        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();
            int x1 = poll[0];
            int y1 = poll[1];
            int cost = poll[2];

            for(int i=0;i<nX.length;i++) {
                int x2 = x1 + nX[i];
                int y2 = y1 + nY[i];
                int wall2 = cost;

                if(x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map[0].length)
                    continue;

                if(map[x2][y2] == 1)
                    ++wall2;

                if(wall2 < dist[x2][y2]) {
                    dist[x2][y2] = wall2;
                    pq.offer(new int[]{x2, y2, wall2});
                }
            }
        }
    }
}
