package Baekjoon.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/4386 (별자리 만들기)
 * @classfication: kruskal
 * @문제 푼 날짜 (자력으로 풂?): 23.12.16 (O)
 **/
public class Q4386 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parents = new int[n];

        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            float x = Float.parseFloat(st.nextToken());
            float y = Float.parseFloat(st.nextToken());

            nodes[i] = new Node(i, x, y);
            parents[i] = i;
        }

        br.close();

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> (int) (e1.dist - e2.dist));

        for (int i = 0; i < n-1; i++) {
            Node n1 = nodes[i];
            for (int j = i + 1; j < n; j++) {
                Node n2 = nodes[j];

                pq.offer(new Edge(n1.num, n2.num, getDist(n1.x, n1.y, n2.x, n2.y)));
            }
        }

        float mst = 0;

        while( !pq.isEmpty() ) {
            Edge edge = pq.poll();

            if(find(edge.n1) != find(edge.n2)) {
                union(edge.n1, edge.n2);
                mst += edge.dist;
            }
        }

        System.out.printf("%.2f", mst);
    }

    private static void union(int n1, int n2) {
        int r1 = find(n1), r2 = find(n2);

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

    private static float getDist(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }

    static class Node {
        int num;
        float x;
        float y;

        public Node(int num, float x, float y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        int n1;
        int n2;
        float dist;

        public Edge(int n1, int n2, float dist) {
            this.n1 = n1;
            this.n2 = n2;
            this.dist = dist;
        }
    }
}
