package Baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/7576 (토마토)
 * @classfication: bfs
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.06.06 (O)
 **/
public class Q7576 {
    static int[][] graph;
    static int M;
    static int N;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();

        graph = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<M;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(graph[i][j] == 1)
                    queue.offer(new int[]{i,j,0});
            }
        }

        System.out.print(printAnswer(bfs()));
    }

    private static int bfs() {
        int d = 0;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            d = poll[2];

            for(int i=0;i<4;i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(graph[nx][ny] == 0) {
                    graph[nx][ny] = 1;
                    queue.offer(new int[]{nx,ny,d+1});
                }
            }
        }

        return d;
    }

    private static int printAnswer(int days) {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(graph[i][j] == 0)
                    return -1;
            }
        }

        return days;
    }
}
