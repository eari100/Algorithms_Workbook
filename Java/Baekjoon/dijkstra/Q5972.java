package Baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/5972 (택배 배송)
 * @classfication: dijkstra
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.14 (O, `두 개의 헛간은 하나 이상의 길로 연결되어 있을 수도 있습니다` -> 다익스트라 와 우선순위 큐에서 처리해주기 때문에 신경 쓸 필요 없습니다)
 **/
public class Q5972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        final int INF = 1000 * N + 1;
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for(int i=0;i<N+1;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new int[]{B, C});
            graph.get(B).add(new int[]{A, C});
        }
        br.close();

        dijkstra(graph, dist);
        System.out.print(dist[N]);
    }

    private static void dijkstra(ArrayList<ArrayList<int[]>> graph, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1]-p2[1]);
        pq.offer(new int[]{1, dist[1]});

        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();

            if(dist[poll[0]] < poll[1]) continue;

            for(int[] arr : graph.get(poll[0])) {
                if(dist[arr[0]] > poll[1] + arr[1]) {
                    dist[arr[0]] = poll[1] + arr[1];
                    pq.offer(new int[]{arr[0], dist[arr[0]]});
                }
            }
        }
    }
}
