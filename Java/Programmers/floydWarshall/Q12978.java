package Programmers.floydWarshall;

import java.util.Arrays;

/**
 * @source: https://school.programmers.co.kr/learn/courses/30/lessons/12978 (배달)
 * @classification: floyd-warshall
 * @문제 푼 날짜 (자력으로 풂?): 24.08.15 (X)
 **/
public class Q12978 {
    public int solution(int N, int[][] road, int K) {
        int answer = 1;
        final int INF = 2001;
        int[][] road2 = new int[N+1][N+1];
        for(int[] r : road2) {
            Arrays.fill(r, INF);
        }

        for(int[] r : road) {
            int s = r[0], e = r[1], dist = r[2];
            road2[s][e] = Math.min(road2[s][e], dist);
            road2[e][s] = Math.min(road2[e][s], dist);
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                for(int k=1;k<=N;k++) {
                    if(road2[j][i] < INF && road2[i][k] < INF) {
                        road2[j][k] = Math.min(road2[j][k], road2[j][i] + road2[i][k]);
                    }
                }
            }
        }

        for(int i=2;i<=N;i++) {
            if(road2[1][i] <= K) {
                ++answer;
            }
        }

        return answer;
    }
}
