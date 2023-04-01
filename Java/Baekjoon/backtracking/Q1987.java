package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1987 (알파벳)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 23.04.01 (O, longestDist 초기 값 설정 주의)
 **/
public class Q1987 {
    static int longestDist = 1;
    static boolean[] visited = new boolean[26];
    static char[][] board;
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for(int x=0;x<R;x++) {
            String row = br.readLine();
            for(int y=0;y<C;y++) {
                board[x][y] = row.charAt(y);
            }
        }

        br.close();

        visited[board[0][0] - 65] = true;
        dfs(1, 0, 0);

        System.out.print(longestDist);
    }

    private static void dfs(int depth, int x1, int y1) {
        for(int i=0;i<nx.length;i++) {
            int x2 = x1 + nx[i];
            int y2 = y1 + ny[i];

            if(x2 < 0 || x2 > board.length - 1 || y2 < 0 || y2 > board[0].length - 1) continue;
            if(visited[board[x2][y2] - 65]) continue;

            visited[board[x2][y2] - 65] = true;
            longestDist = Math.max(longestDist, depth+1);
            dfs(depth+1, x2, y2);
            visited[board[x2][y2] - 65] = false;
        }
    }
}
