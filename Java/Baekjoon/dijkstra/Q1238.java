package Baekjoon.dijkstra;

import java.io.*;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/1238 (파티)
 * @classification: dijkstra
 * @문제 푼 날짜 (자력으로 풂?): 23.12.08 (O)
 **/
// todo: dijkstra 2개만을 사용해서 성능향상할 것
public class Q1238 {
    static ArrayList<int[]>[] graph;
    static final int INF = 10_000 * 100 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;

        graph = new ArrayList[N];
        for(int i=0;i<graph.length;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());

            graph[s].add(new int[]{e, dist});
        }

        br.close();

        int maxDist = 0;

        int[] distArr2 = dijkstra(X);

        for(int i=0;i<N;i++) {
            if(i == X) continue;

            int[] distArr1 = dijkstra(i);

            maxDist = Math.max(maxDist, distArr1[X] + distArr2[i]);
        }

        bw.write(String.valueOf(maxDist));
        bw.flush();
        bw.close();
    }

    private static int[] dijkstra(int strNode) {
        int[] distArr = new int[graph.length];
        Arrays.fill(distArr, INF);
        distArr[strNode] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        pq.offer(new int[]{strNode, 0});

        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();
            int node1 = poll[0];
            int dist1 = poll[1];

            for(int[] network : graph[node1]) {
                int node2 = network[0];
                int dist2 = network[1];

                int totalDist = dist1 + dist2;
                if(distArr[node2] > totalDist) {
                    distArr[node2] = totalDist;
                    pq.offer(new int[]{node2, totalDist});
                 }
            }
        }

        return distArr;
    }
}
