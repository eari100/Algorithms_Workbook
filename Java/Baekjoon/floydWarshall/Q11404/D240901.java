package Baekjoon.floydWarshall.Q11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/11404 (플로이드)
 * @classification: floyd-warshall
 * @문제 푼 날짜 (자력으로 풂?): 24.09.02 (O)
 **/
public class D240901 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        final int INF = 10_000_000 + 1;

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i == j) continue;
                map[i][j] = INF;
            }
        }

        StringTokenizer st;

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int str = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            map[str][end] = Math.min(map[str][end], cost);
        }

        br.close();

        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(map[i][k] < INF && map[k][j] < INF)
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for(int[] arr : map) {
            for(int item : arr) {
                result.append(item < INF ? item : 0).append(' ');
            }
            result.append('\n');
        }

        System.out.print(result);
    }
}
