package Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/17484 (진우의 달 여행 (Small))
 * @classification: brute-force
 * @문제 푼 날짜 (자력으로 풂?): 23.12.27 (O)
 **/
// todo: dp로 풀 것
public class Q17484 {
    static int[][] space;
    static int minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        space = new int[n][m];
        minCost = n * 100;

        for(int i=0;i<n;i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());

            for(int j=0;j<m;j++) {
                space[i][j] = Integer.parseInt(row.nextToken());
            }
        }

        br.close();

        for(int i=0;i<m;i++)
            dfs(1, i, 10, space[0][i]);

        System.out.print(minCost);
    }

    private static void dfs(int depth, int prevIdx, int direction, int cost) {
        if(depth == space.length) {
            minCost = Math.min(minCost, cost);
            return;
        }

        if(direction == -1) {
            dfs(depth+1, prevIdx, 0,cost+space[depth][prevIdx]);

            if(prevIdx+1 < space[0].length)
                dfs(depth+1, prevIdx+1, 1,cost+space[depth][prevIdx+1]);
        } else if(direction == 0) {
            if(prevIdx-1 >= 0)
                dfs(depth+1, prevIdx-1, -1,cost+space[depth][prevIdx-1]);

            if(prevIdx+1 < space[0].length)
                dfs(depth+1, prevIdx+1, 1,cost+space[depth][prevIdx+1]);
        } else if(direction == 1) {
            if(prevIdx-1 >= 0)
                dfs(depth+1, prevIdx-1, -1,cost+space[depth][prevIdx-1]);

            dfs(depth+1, prevIdx, 0,cost+space[depth][prevIdx]);
        } else if(direction == 10) {
            if(prevIdx-1 >= 0)
                dfs(depth+1, prevIdx-1, -1,cost+space[depth][prevIdx-1]);

            dfs(depth+1, prevIdx, 0,cost+space[depth][prevIdx]);

            if(prevIdx+1 < space[0].length)
                dfs(depth+1, prevIdx+1, 1,cost+space[depth][prevIdx+1]);
        }
    }
}
