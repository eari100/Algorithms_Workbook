package Baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * @source: https://www.acmicpc.net/problem/1504 (특정한 최단 경로)
 * @classification: dijkstra
 * @문제 푼 날짜 (자력으로 풂?): 23.12.03 (X)
 **/
public class Q1504 {
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        final int INF = 200_000 * 1_000 + 1;

        for(int i=0;i<N;i++)
            graph[i] = new ArrayList<>();

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());

            int str = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            graph[str].add(new int[]{end, cost});
            graph[end].add(new int[]{str, cost});
        }

        st = new StringTokenizer(br.readLine());

        int essentials1 = Integer.parseInt(st.nextToken()) - 1;
        int essentials2 = Integer.parseInt(st.nextToken()) - 1;

        br.close();

        int[] costs1 = new int[N];
        Arrays.fill(costs1, INF);
        dijkstra(0, costs1);
        int zeroToE1 = costs1[essentials1];
        int zeroToE2 = costs1[essentials2];

        int[] costs2 = new int[N];
        Arrays.fill(costs2, INF);
        dijkstra(essentials1, costs2);
        int e1ToE2 = costs2[essentials2];
        int e1ToEnd = costs2[N-1];

        int[] costs3 = new int[N];
        Arrays.fill(costs3, INF);
        dijkstra(essentials2, costs3);
        int e2ToE1 = costs3[essentials1];
        int e2ToEnd = costs3[N-1];

        int result1 = INF, result2 = INF;

        if(zeroToE1 < INF && e1ToE2 < INF && e2ToEnd < INF)
            result1 = zeroToE1 + e1ToE2 + e2ToEnd;

        if(zeroToE2 < INF && e2ToE1 < INF && e1ToEnd < INF)
            result2 = zeroToE2 + e2ToE1 + e1ToEnd;

        int result = Math.min(result1, result2);

        System.out.print(result == INF ? -1 : result);
    }

    private static int[] dijkstra(int str, int[] costs) {
        costs[str] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        pq.offer(new int[]{str, 0});

        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();

            int currNode = poll[0];
            int currCost = poll[1];

            for(int[] network : graph[currNode]) {
                int nextNode = network[0];
                int nextCost = network[1];

                if(costs[nextNode] > currCost + nextCost) {
                    costs[nextNode] = currCost + nextCost;
                    pq.offer(new int[]{nextNode, costs[nextNode]});
                }
            }
        }

        return costs;
    }
}
