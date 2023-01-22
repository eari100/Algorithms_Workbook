package Baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/10655 (마라톤 1)
 * @classfication: math, brute-force
 * @문제 푼 날짜 (자력으로 풂?): 23.01.22 (X)
 **/
public class Q10655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][2];
        int sumDist = 0;
        int minDist = 0;

        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());

            if(i>0) sumDist += getManhattanDistance(graph[i][0], graph[i][1], graph[i-1][0], graph[i-1][1]);
        }
        br.close();

        for(int i=1;i<graph.length-1;i++) {
            int d1 = getManhattanDistance(graph[i-1][0], graph[i-1][1], graph[i][0], graph[i][1])
                    + getManhattanDistance(graph[i][0], graph[i][1], graph[i+1][0], graph[i+1][1]);
            int d2 = getManhattanDistance(graph[i-1][0], graph[i-1][1], graph[i+1][0], graph[i+1][1]);

            minDist = Math.min(minDist, d2-d1);
        }

        System.out.print(sumDist + minDist);
    }

    private static int getManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}
