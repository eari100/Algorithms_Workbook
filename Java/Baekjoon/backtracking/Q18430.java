package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/18430 (무기 공학)
 * @classfication: backtracking
 * @reference: https://astrid-dm.tistory.com/511
 * @문제 푼 날짜 (자력으로 풂?): 23.02.19 (X)
 **/
public class Q18430 {
    static int[][] 나무재료;
    static boolean[][] visited;
    static int 최고강도;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        나무재료 = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++) {
                나무재료[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        backtracking(0, 0, 0);

        System.out.print(최고강도);
    }

    private static void backtracking(int x, int y, int 강도) {
        if(y == M) {
            y = 0;
            ++x;
        }

        if(x == N) {
            최고강도 = Math.max(최고강도, 강도);
            return;
        }

        if(!visited[x][y]) {
            if(x+1 < N && y-1 >= 0 && !visited[x][y-1] && !visited[x+1][y]) {
                int 추가강도 = 2 * 나무재료[x][y] + 나무재료[x][y-1] + 나무재료[x+1][y];
                visited[x][y] = visited[x][y-1] = visited[x+1][y] = true;
                backtracking(x, y+1, 강도 + 추가강도);
                visited[x][y] = visited[x][y-1] = visited[x+1][y] = false;
            }
            if(x-1 >= 0 && y-1 >= 0 && !visited[x][y-1] && !visited[x-1][y]) {
                int 추가강도 = 2 * 나무재료[x][y] + 나무재료[x][y-1] + 나무재료[x-1][y];
                visited[x][y] = visited[x][y-1] = visited[x-1][y] = true;
                backtracking(x, y+1, 강도 + 추가강도);
                visited[x][y] = visited[x][y-1] = visited[x-1][y] = false;
            }
            if(x-1 >= 0 && y+1 < M && !visited[x-1][y] && !visited[x][y+1]) {
                int 추가강도 = 2 * 나무재료[x][y] + 나무재료[x][y+1] + 나무재료[x-1][y];
                visited[x][y] = visited[x][y+1] = visited[x-1][y] = true;
                backtracking(x, y+1, 강도 + 추가강도);
                visited[x][y] = visited[x][y+1] = visited[x-1][y] = false;
            }
            if(x+1 < N && y+1 < M && !visited[x][y+1] && !visited[x+1][y]) {
                int 추가강도 = 2 * 나무재료[x][y] + 나무재료[x][y+1] + 나무재료[x+1][y];
                visited[x][y] = visited[x][y+1] = visited[x+1][y] = true;
                backtracking(x, y+1, 강도 + 추가강도);
                visited[x][y] = visited[x][y+1] = visited[x+1][y] = false;
            }
        }

        backtracking(x, y+1, 강도);
    }
}
