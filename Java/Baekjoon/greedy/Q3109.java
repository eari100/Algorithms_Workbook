package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/3109 (빵집)
 * @classification: greedy, dfs
 * @문제 푼 날짜 (자력솔?): 25.06.09 (X)
 **/
public class Q3109 {
    final static int[][] moves = {{-1, 1}, {0, 1}, {1, 1}};
    static int answer = 0;
    static boolean[][] map;
    static boolean[][] visited;
    static boolean finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new boolean[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j) == '.';
            }
        }

        br.close();

        for(int i=0;i<r;i++) {
            finished = false;
            bt(i, 0);
        }

        System.out.print(answer);
    }

    private static void bt(int x, int y) {
        visited[x][y] = true;

        if(y == map[0].length - 1) {
            answer++;
            finished = true;
            return;
        }

        for(int[] move : moves) {
            int x2 = x + move[0];
            int y2 = y + move[1];

            if( x2 < 0 || x2 >= map.length || y2 < 0 || y2 >= map[0].length || visited[x2][y2] || !map[x2][y2] ) continue;

            visited[x][y] = true;
            bt(x2, y2);

            if(finished) return;
        }
    }
}
