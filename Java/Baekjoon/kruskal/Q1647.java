package Baekjoon.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1647 (도시 분할 계획)
 * @classification: kruskal
 * @문제 푼 날짜 (자력으로 풂?): 23.12.22 (O)
 **/
public class Q1647 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        parents = new int[N+1];

        for(int i=1;i<N;i++)
            parents[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[2] - p2[2]);

        int mst = 0;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());;

            pq.offer(new int[]{str, end, dist});
        }

        br.close();

        int nodeCnt = 0;
        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();
            int n1 = poll[0], n2 = poll[1], dist = poll[2];

            if(find(n1) != find(n2)) {
                union(n1, n2);

                if(nodeCnt == N-2) continue;

                mst += dist;
                ++nodeCnt;
            }
        }

        System.out.print(mst);
    }

    private static void union(int n1, int n2) {
        int r1 = find(n1), r2 = find(n2);

        if(r1 < r2)
            parents[r2] = r1;
        else if(r1 > r2)
            parents[r1] = r2;
    }

    private static int find(int n) {
        if(parents[n] == n) {
            return n;
        }

        return parents[n] = find(parents[n]);
    }
}
