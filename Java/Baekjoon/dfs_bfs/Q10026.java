package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/10026 (적록색약)
 * @classfication: dfs
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.17 (O)
 **/
public class Q10026 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] normal = new char[N][N];
        char[][] weakness = new char[N][N];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                char color = str.charAt(j);
                normal[i][j] = color;
                weakness[i][j] = color == 'G' ? 'R' : color;
            }
        }

        br.close();

        int normalSpace = 0;
        int weaknessSpace = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(normal[i][j] != 'X')  {
                    dfs(normal, i, j);
                    ++normalSpace;
                }

                if(weakness[i][j] != 'X') {
                    dfs(weakness, i, j);
                    ++weaknessSpace;
                }
            }
        }

        System.out.print(normalSpace + " " + weaknessSpace);
    }

    private static void dfs(char[][] graph, int x, int y) {
        char color = graph[x][y];
        graph[x][y] = 'X';

        for(int i=0;i<dx.length;i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx < 0 || nx > graph.length-1 || ny < 0 || ny > graph.length-1) continue;

            char compareColor = graph[nx][ny];
            if(compareColor == color) dfs(graph, nx, ny);
        }
    }
}
