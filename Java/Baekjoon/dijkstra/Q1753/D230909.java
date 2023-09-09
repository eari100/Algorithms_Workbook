package Baekjoon.dijkstra.Q1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1753 (최단경로)
 * @classfication: dijkstra
 * @문제 푼 날짜 (자력으로 풂?): 23.09.09 (X, 인접 행렬을 구상하지 못함, 다익스트라를 잊어버림)
 **/
public class D230909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int str = Integer.parseInt(br.readLine()) - 1;

        final int INF = V * 10 + 1;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i=0;i<V;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            graph.get(s).add(new int[]{e, d});
        }

        br.close();

        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[str] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((q1, q2) -> q1[1] - q2[1]);
        queue.offer(new int[]{str, 0});

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int s = poll[0];
            int d1 = poll[1];
            ArrayList<int[]> nodes = graph.get(s);

            for(int[] n : nodes) {
                int e = n[0];
                int d2 = n[1];
                int sD = d1 + d2;

                if(dist[e] > sD) {
                    dist[e] = sD;
                    queue.offer(new int[]{e, sD});
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for(long l : dist) {
            result.append(l == INF ? "INF" : l).append('\n');
        }

        System.out.print(result);
    }
}
