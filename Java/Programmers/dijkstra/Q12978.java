package Programmers.dijkstra;

import java.util.PriorityQueue;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12978 (배달)
 * @classification: dijkstra
 * @문제 푼 날짜 (자력으로 풂?): 24.08.17 (X)
 **/
public class Q12978 {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        final int INF = 10000 * 2000 + 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        pq.offer(new int[]{1, 0});

        int[] distances = new int[N+1];

        for(int i=2;i<=N;i++) {
            distances[i] = INF;
        }

        boolean[] visited = new boolean[N+1];

        int[][] road2 = new int[N+1][N+1];

        for(int i=0;i<road2.length;i++) {
            for(int j=0;j<road2[0].length;j++) {
                if(i == j) continue;

                road2[i][j] = INF;
            }
        }

        for(int[] r : road) {
            int s = r[0], e = r[1], dist = r[2];
            road2[s][e] = Math.min(road2[s][e], dist);
            road2[e][s] = Math.min(road2[e][s], dist);
        }

        while( !pq.isEmpty() ) {
            int[] poll = pq.poll();
            int str = poll[0];

            if( visited[str] ) continue;

            visited[str] = true;

            for(int end=1;end<road2[str].length;end++) {
                if( visited[end] ) continue;
                if( road2[str][end] == INF ) continue;

                distances[end] = Math.min(distances[end], distances[str] + road2[str][end]);
                pq.offer(new int[]{end, distances[end]});
            }
        }

        for(int i=1;i<distances.length;i++) {
            if(distances[i] <= K) {
                ++answer;
            }
        }

        return answer;
    }
}
