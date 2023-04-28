package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/14502 (연구소)
 * @classfication: bfs, backtracking
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.05.24 (X, 벽 3개 쌓는 부분 backtracking 하는 방법 참고, https://hongcoding.tistory.com/m/130)
 * 2. 23.04.28 (X, 벽 3개 쌓는 부분 삼중 for문으로 구상을 못해서 업솔빙 실패, https://www.acmicpc.net/source/21403174 이렇게 하고 싶었음)
 **/
public class Q14502 {
    static int[][] graph;
    static int[][] tmp;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        tmp = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        makeWall(0);
        System.out.print(answer);
    }

    private static void bfs() {
        for(int i=0;i<tmp.length;i++) {
            System.arraycopy(graph[i], 0, tmp[i], 0, tmp[i].length);
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int nx, ny = 0;
        int clean = 0;

        Queue<int[]> queue;

        for(int i=0;i<tmp.length;i++) {
            for(int j=0;j<tmp[0].length;j++) {
                if(tmp[i][j] == 2) {
                    queue  = new LinkedList<>();
                    queue.offer(new int[]{i,j});

                    while( !queue.isEmpty() ) {
                        int[] poll = queue.poll();

                        for(int k=0;k<4;k++) {
                            nx = poll[0] + dx[k];
                            ny = poll[1] + dy[k];

                            if(nx < 0 || nx >= tmp.length || ny < 0 || ny >= tmp[0].length) continue;
                            if(tmp[nx][ny] == 0) {
                                queue.offer(new int[]{nx, ny});
                                tmp[nx][ny] = 2;
                            }
                        }
                    }
                }
            }
        }

        for(int i=0;i<tmp.length;i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                if(tmp[i][j] == 0) ++clean;
            }
        }

        answer = Math.max(answer, clean);
    }

    private static void makeWall(int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }

        for(int i=0;i<graph.length;i++) {
            for(int j=0;j<graph[0].length;j++) {
                if(graph[i][j] == 0) {
                    graph[i][j] = 3;
                    makeWall(cnt+1);
                    graph[i][j] = 0;
                }
            }
        }
    }
}
