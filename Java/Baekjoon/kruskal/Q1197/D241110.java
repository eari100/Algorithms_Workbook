package Baekjoon.kruskal.Q1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1197 (최소 스패닝 트리)
 * @classification: kruskal, mst
 * @문제 푼 날짜 (자력으로 풂?): 24.11.10 (크루스칼 알고리즘 복습)
 **/
public class D241110 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]);
        parents = new int[v];

        for(int i=1;i<v;i++) {
            parents[i] = i;
        }

        for(int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a, b, cost});
        }

        br.close();

        int mst = 0;

        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();
            int a = poll[0], b = poll[1], cost = poll[2];

            if(!union(a, b)) continue;

            mst += cost;
        }

        System.out.print(mst);
    }

    private static boolean union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(p1 == p2) {
            return false;
        }

        if(p1 > p2) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
        }

        return true;
    }

    private static int find(int node) {
        if(parents[node] == node) {
            return node;
        }

        return find(parents[node]);
    }
}
