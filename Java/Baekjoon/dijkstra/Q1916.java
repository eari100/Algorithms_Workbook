package Baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1916 (최소비용 구하기)
 * @classfication: dijkstra
 * @문제 푼 날짜 (자력으로 풂?): 23.01.21 (X, INF 값 잘못 지정)
 **/
public class Q1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        long[] dist = new long[N+1];
        final int INF = 100000001;

        Arrays.fill(dist, INF);

        for(int i=0;i<N+1;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int strNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(strNode).add(new int[]{endNode, cost});
        }

        st = new StringTokenizer(br.readLine());

        int strNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        br.close();

        dist[strNode] = 0;
        dijkstra(graph, dist, strNode);

        System.out.print(dist[endNode]);
    }

    private static long[] dijkstra(ArrayList<ArrayList<int[]>> graph, long[] dist, int strNode) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((p1, p2) -> (int) (p1[1] - p2[1]));
        pq.offer(new long[]{strNode, dist[strNode]});

        while( !pq.isEmpty() ) {
            long[] poll = pq.poll();
            long node1 = poll[0];
            long cost1 = poll[1];

            if(dist[(int) node1] < cost1) continue;

            for(int[] arr : graph.get((int) node1)) {
                int node2 = arr[0];
                int cost2 = arr[1];

                if(cost1 + cost2 < dist[node2]) {
                    dist[node2] = cost1 + cost2;
                    pq.offer(new long[]{node2, dist[node2]});
                }
            }
        }

        return dist;
    }
}