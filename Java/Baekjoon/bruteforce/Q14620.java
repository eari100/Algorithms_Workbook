package Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14620 (꽃길)
 * @classification: brute force
 * @문제 푼 날짜 (자력으로 풂?): 23.11.30 (O)
 **/
public class Q14620 {
    static final int[] nX = {-1, 0, 1, 0};
    static final int[] nY = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int minCost = 200 * 15;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        dfs(0, 0);
        System.out.print(minCost);
    }

    private static void dfs(int depth, int cost) {
        if(depth == 3) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for(int i=1;i<map.length-1;i++) {
            L1: for(int j=1;j<map[0].length-1;j++) {
                if(visited[i][j])
                    continue;
                int cost2 = map[i][j];

                ArrayList<int[]> visitedLog = new ArrayList<>();
                for(int k=0;k<nX.length;k++) {
                    if(visited[i+nX[k]][j+nY[k]]) {
                        for(int[] v : visitedLog) {
                            visited[v[0]][v[1]] = false;
                        }

                        continue L1;
                    }

                    visitedLog.add(new int[]{i+nX[k], j+nY[k]});
                    cost2 += map[i+nX[k]][j+nY[k]];
                    visited[i+nX[k]][j+nY[k]] = true;
                }

                visited[i][j] = true;

                dfs(depth+1, cost + cost2);

                visited[i][j] = false;

                for(int k=0;k<nX.length;k++) {
                    visited[i+nX[k]][j+nY[k]] = false;
                }
            }
        }
    }
}
