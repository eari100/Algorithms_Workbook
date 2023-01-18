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
 * @문제 푼 날짜 (자력으로 풂?): 23.01.18 (X)
 **/
public class D230118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        final int INF = E*10+1;
        int[] distArr = new int[V+1];
        Arrays.fill(distArr, INF);

        int strIdx = Integer.parseInt(br.readLine());
        distArr[strIdx] = 0;

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

        distArr = dijkstra(graph, distArr, strIdx);

        System.out.print(printAnswer(distArr, INF));
    }

    private static int[] dijkstra(ArrayList<ArrayList<int[]>> graph, int[] distArr, int strIdx) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->p1[1]-p2[1]);
        pq.offer(new int[]{strIdx, 0});

        while(!pq.isEmpty()) {
            int[] poll = pq.poll();
            int endIdx = poll[0];
            int dist = poll[1];

            if(distArr[endIdx] < dist) continue;

            for(int[] arr : graph.get(endIdx)) {
                int newDist = dist + arr[1];

                if(distArr[arr[0]] > newDist) {
                    distArr[arr[0]] = newDist;
                    pq.offer(new int[]{arr[0], distArr[arr[0]]});
                }
            }
        }

        return distArr;
    }

    private static String printAnswer(int[] distArr, int INF) {
        StringBuilder answer = new StringBuilder();

        for(int i=1;i<distArr.length;i++)
            answer.append(distArr[i] == INF ? "INF" : distArr[i]).append('\n');

        return answer.toString();
    }
}
