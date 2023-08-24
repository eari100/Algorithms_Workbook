package Programmers.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/49189 (가장 먼 노드)
 * @classfication: bfs
 * @문제 푼 날짜 (혼자 힘으로 풂?): 23.08.25 (O)
 **/
public class Q49189 {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];

        for(int i=0;i<n+1;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edge) {
            int str = e[0];
            int end = e[1];

            graph[str].add(end);
            graph[end].add(str);
        }

        return bfs(graph);
    }

    private int bfs(ArrayList<Integer>[] graph) {
        int count = 0;

        int[] dist = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;
        int longestDist = 0;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();

            int node1 = poll[0];
            int dist1 = poll[1];

            ArrayList<Integer> g = graph[node1];

            for(int node2 : g) {
                if(visited[node2]) continue;

                int dist2 = dist1 + 1;

                dist[node2] = dist2;
                queue.offer(new int[]{node2, dist2});
                visited[node2] = true;

                if(longestDist < dist2) {
                    count = 1;
                    longestDist = dist2;
                } else if(longestDist == dist2) {
                    ++count;
                }
            }
        }

        return count;
    }
}
