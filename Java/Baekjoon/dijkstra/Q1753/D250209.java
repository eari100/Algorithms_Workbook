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
 * @문제 푼 날짜 (자력으로 풂?): 25.02.09 (O)
 **/
public class D250209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // max: 20000
        int e = Integer.parseInt(st.nextToken()); // max: 300000
        final int INF = 10 * e + 1;
        StringBuilder result = new StringBuilder();

        int[] dist_arr = new int[v];
        Arrays.fill(dist_arr, INF);
        int str = Integer.parseInt(br.readLine()) - 1;
        dist_arr[str] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        pq.offer(new int[]{str, dist_arr[str]});

        ArrayList<int[]>[] graph = new ArrayList[v];

        for(int i=0;i<v;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, w});
        }

        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();
            int prev_node = poll[0];
            int prev_cost = poll[1];

            for(int[] g : graph[prev_node]) {
                int next_node = g[0];
                int next_cost = g[1];

                int total_cost = prev_cost + next_cost;
                if(total_cost < dist_arr[next_node]) {
                    dist_arr[next_node] = total_cost;
                    pq.offer(new int[]{next_node, dist_arr[next_node]});
                }
            }
        }

        br.close();

        for(int d : dist_arr) {
            result.append(d == INF ? "INF" : d).append('\n');
        }

        System.out.print(result);
    }
}
