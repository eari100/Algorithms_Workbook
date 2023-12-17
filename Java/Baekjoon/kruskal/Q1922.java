package Baekjoon.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1922 (네트워크 연결)
 * @classification: kruskal
 * @문제 푼 날짜 (자력으로 풂?): 23.12.18 (O)
 **/
public class Q1922 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parents = new int[n+1];

        for(int i=1;i<=n;i++)
            parents[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]);

        for(int i=0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{s, e, cost});
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
        if(parents[n] == n)
            return n;

        return parents[n] = find(parents[n]);
    }
}
