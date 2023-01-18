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
 * @reference: https://codingnojam.tistory.com/46
 * @문제 푼 날짜 (자력으로 풂?): 22.07.13 (X)
 **/
public class D220713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        final int INF = 10 * V + 1;
        int[] distance = new int[V+1];
        Arrays.fill(distance, INF);

        int str = Integer.parseInt(br.readLine());
        distance[str] = 0;

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i=0;i<V+1;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, w});
        }

        br.close();

        dijkstra(distance, str, graph);
        System.out.println(printAnswer(distance, INF));
    }

    private static void dijkstra(int[] distance, int str,  ArrayList<ArrayList<int[]>> graph) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->p1[1]-p2[1]);
        pq.offer(new int[]{str, 0});

        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();

            if(distance[poll[0]] < poll[1]) continue;

            for(int[] arr : graph.get(poll[0])) {
                if(distance[arr[0]] > poll[1] + arr[1]) {
                    distance[arr[0]] = poll[1] + arr[1];
                    pq.offer(new int[]{arr[0], distance[arr[0]]});
                }
            }
        }
    }

    private static StringBuilder printAnswer(int[] distance, int INF) {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<distance.length;i++) {
            sb.append(distance[i] < INF ? distance[i] : "INF").append('\n');
        }

        return sb;
    }
}
