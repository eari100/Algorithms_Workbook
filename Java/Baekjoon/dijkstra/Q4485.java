package Baekjoon.dijkstra;

import java.io.*;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/4485 (녹색 옷 입은 애가 젤다지?)
 * @classfication: dijkstra
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.16 (O, 힌트 사용)
 **/
public class Q4485 {
    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        dx = new int[]{-1, 1, 0, 0};
        dy = new int[]{0, 0, -1, 1};
        int testCase = 0;

        while(true) {
            ++testCase;
            int N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            final int INF = N * N * 9 + 1;
            int[][] graph = new int[N][N];
            int[][] dist = new int[N][N];

            for(int i=0;i<graph.length;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<graph.length;j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            dist[0][0] = graph[0][0];

            dijkstra(graph, dist);
            result.append(printAnswer(dist[N-1][N-1], testCase)).append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static void dijkstra(int[][] graph, int[][] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]);
        pq.offer(new int[]{0, 0, dist[0][0]});

        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();

            if(poll[2] > dist[poll[0]][poll[1]]) continue;

            for(int i=0;i<4;i++) {
                int nx = dx[i] + poll[0];
                int ny = dy[i] + poll[1];

                if(nx<0 || nx>graph.length-1 || ny<0 || ny>graph.length-1) continue;

                if(dist[nx][ny] > dist[poll[0]][poll[1]]+graph[nx][ny]) {
                    dist[nx][ny] = dist[poll[0]][poll[1]]+graph[nx][ny];
                    pq.offer(new int[]{nx, ny, graph[nx][ny]});
                }
            }
        }
    }

    private static StringBuilder printAnswer(int min, int testCase) {
        StringBuilder sb = new StringBuilder("Problem ");
        sb.append(testCase).append(": ").append(min);

        return sb;
    }
}
