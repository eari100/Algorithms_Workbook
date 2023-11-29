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
 * @문제 푼 날짜 (자력으로 풂?): 23.11.29 (X, 구상은 했으나 우선순위 큐에 넣기 전에 거리 비교를 해주지 않아서 시간초과가 남)
 **/
public class D231129 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int str = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        final int INF = 300_000 * 10 + 1;

        ArrayList<int[]>[] graph = new ArrayList[v+1];

        for(int i=1;i<v+1;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());

            int s2 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[s2].add(new int[]{e2, cost});
        }

        br.close();

        int[] dist = new int[v+1];
        Arrays.fill(dist, INF);
        dist[str] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((pq1, pq2) -> pq1[1] - pq2[1]);
        pq.offer(new int[]{str, 0});


        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();
            int prevNode = poll[0];
            int prevCost = poll[1];

            for(int[] n : graph[prevNode]) {
                int currNode = n[0];
                int currCost = n[1];

                int dist1 = dist[currNode];
                int dist2 = prevCost + currCost;

                if(dist1 > dist2) {
                    dist[currNode] = dist2;
                    pq.offer(new int[]{currNode, dist2});
                }
            }
        }

        for(int i=1;i<dist.length;i++)
            result.append(dist[i] < INF ? dist[i] : "INF").append('\n');

        System.out.print(result);
    }
}
