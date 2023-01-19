package Baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/10282 (해킹)
 * @classfication: dijkstra
 * @문제 푼 날짜 (자력으로 풂?): 23.01.20 (X)
 **/
public class Q10282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++) {
            int virusComCnt = 0, maxDist = 0;
            ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int INF = 1000 * d + 1;

            for(int j=0;j<n+1;j++)
                graph.add(new ArrayList<>());

            int[] dist = new int[n+1];
            Arrays.fill(dist, INF);

            dist[c] = 0;

            for(int j=0;j<d;j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph.get(b).add(new int[]{a, s});
            }

            dist = dijkstra(graph, dist, c);

            for(int dt : dist) {
                if(dt != INF) {
                    ++virusComCnt;
                    maxDist = Math.max(maxDist, dt);
                }
            }

            result.append(virusComCnt).append(' ').append(maxDist).append('\n');
        }
        br.close();
        System.out.print(result);
    }

    private static int[] dijkstra(ArrayList<ArrayList<int[]>> graph, int[] dist, int strNode) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        pq.offer(new int[]{strNode, dist[strNode]});

        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();
            int node1 = poll[0];
            int dist1 = poll[1];

            if(dist[node1] < dist1) continue;

            for(int[] arr : graph.get(node1)) {
                int node2 = arr[0];
                int dist2 = arr[1];

                if(dist[node2] > dist1 + dist2) {
                    dist[node2] = dist1 + dist2;
                    pq.offer(new int[]{node2, dist[node2]});
                }
            }
        }
        return dist;
    }
}
