package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2468 (안전 영역)
 * @classfication: bfs
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.14 (O, 모든 영역이 물에 잠기지 않는 case 참고함)
 **/
public class Q2468 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        int maxHeight = 0;

        StringTokenizer st;
        int maxSpaceCnt = 1;

        for(int i=0;i<N;i++) {
             st = new StringTokenizer(br.readLine());

             for(int j=0;j<N;j++) {
                 int height = Integer.parseInt(st.nextToken());
                 graph[i][j] = height;
                 maxHeight = Math.max(maxHeight, height);
            }
        }

        br.close();

        for(int i=1;i<=maxHeight;i++) {
            int spaceCnt = 0;
            visited = new boolean[N][N];

            for(int j=0;j<N;j++) {
                for(int k=0;k<N;k++) {

                    if( !visited[j][k] && graph[j][k] > i ) {
                        bfs(j, k, i);
                        ++spaceCnt;
                    }
                }
            }

            maxSpaceCnt = Math.max(maxSpaceCnt, spaceCnt);
        }

        System.out.print(maxSpaceCnt);
    }

    private static void bfs(int x, int y, int waterHeight) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();

            for(int i=0;i<nx.length;i++) {
                int dx = poll[0] + nx[i];
                int dy = poll[1] + ny[i];

                if(dx < 0 || dx >= graph.length || dy < 0 || dy >= graph[0].length) continue;

                if(visited[dx][dy]) continue;

                if(graph[dx][dy] <= waterHeight) continue;

                queue.add(new int[]{dx, dy});
                visited[dx][dy] = true;
            }
        }
    }
}
