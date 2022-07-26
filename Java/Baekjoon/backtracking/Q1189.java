package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1189 (컴백홈)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.26 (X, 맞췄는데 덜렁대서 틀림)
 **/
public class Q1189 {
    static int goal;
    static char[][] graph;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int R;
    static int C;
    static int K;
    static int dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        goal = 0;
        dist = 1;
        graph = new char[R][C];

        for(int i=0;i<R;i++) {
            String line = br.readLine();

            for(int j=0;j<C;j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        br.close();

        graph[R-1][0] = 'T';
        dfs(R-1, 0);

        System.out.print(goal);
    }

    private static void dfs(int x, int y) {
        if(dist == K) {
            if(x == 0 && y == C-1) ++goal;
            return;
        }

        for(int i=0;i<dx.length;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx > R-1 || ny < 0 || ny > C-1) continue;

            if(graph[nx][ny] != 'T') {
                graph[nx][ny] = 'T';
                ++dist;
                dfs(nx, ny);
                graph[nx][ny] = '.';
                --dist;
            }
        }
    }
}
