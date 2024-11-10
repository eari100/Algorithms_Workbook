package Baekjoon.kruskal.Q1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1197 (최소 스패닝 트리)
 * @classification: kruskal, mst
 * @문제 푼 날짜 (자력으로 풂?): 23.12.16 (O)
 **/
public class D231216 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parents = new int[v+1];

        for(int i=1;i<=v;i++) {
            parents[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]);
        for(int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());

            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{str, end, cost});
        }

        br.close();

        int mst = 0;
        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();

            int n1 = poll[0], n2 = poll[1], cost = poll[2];

            if(find(n1) != find(n2)) {
                union(n1, n2);
                mst += cost;
            }
        }

        System.out.print(mst);
    }

    private static void union(int n1, int n2) {
        int r1 = find(n1);
        int r2 = find(n2);

        if(r1 < r2)
            parents[r2] = r1;
        else if(r1 > r2)
            parents[r1] = r2;
    }

    private static int find(int n) {
        if(n == parents[n])
            return n;

        return parents[n] = find(parents[n]);
    }
}
