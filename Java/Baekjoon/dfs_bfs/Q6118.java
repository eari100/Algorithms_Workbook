package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/6118 (숨바꼭질)
 * @classfication: bfs
 * @문제 푼 날짜 (자력솔?): 23.12.24 (O)
 **/
public class Q6118 {
    static int maxDist = 0;
    static PriorityQueue<Integer> maxNodeList = new PriorityQueue<>();
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        StringBuilder answer = new StringBuilder();

        for(int i=1;i<n+1;i++)
            graph[i] = new ArrayList();

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        br.close();

        bfs();

        answer.append(maxNodeList.peek()).append(' ').append(maxDist).append(' ').append(maxNodeList.size());
        System.out.print(answer);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int node1 = poll[0];
            int dist1 = poll[1];

            for(int node2 : graph[node1]) {
                if(visited[node2]) continue;

                visited[node2] = true;
                int dist2 = dist1+1;
                queue.offer(new int[]{node2, dist2});

                if(maxDist < dist2) {
                    maxDist = dist2;
                    maxNodeList = new PriorityQueue<>();
                    maxNodeList.add(node2);
                } else if(maxDist == dist2) {
                    maxNodeList.add(node2);
                }
            }
        }
    }
}
