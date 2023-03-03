package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/2583 (영역 구하기)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.03.04 (O)
 **/
public class Q2583 {
    static int[] nx  = {-1, 1, 0, 0};
    static int[] ny  = {0, 0, -1, 1};
    static int[][] graph;
    static int 영역_수;
    static List<Integer> 영역_넓이_모음 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuilder result = new StringBuilder();

        graph = new int[M][N];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j=x1;j<x2;j++) {
                for(int k=y1;k<y2;k++) {
                    graph[k][j] = -1;
                }
            }
        }

        br.close();

        for(int i=0;i<graph[0].length;i++) {
            for(int j=0;j<graph.length;j++) {
                if(graph[j][i] == 0) {
                    bfs(i, j);
                }
            }
        }

        result.append(영역_수).append('\n');
        Collections.sort(영역_넓이_모음);
        영역_넓이_모음.forEach(영역_넓이 -> result.append(영역_넓이).append(' '));

        System.out.println(result);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        graph[y][x] = 1;
        int 영역_넓이 = 1;

        while( !queue.isEmpty() ) {
            int[] poll = queue.poll();
            int dx = poll[0];
            int dy = poll[1];

            for(int i=0;i<nx.length;i++) {
                int ex = dx + nx[i];
                int ey = dy + ny[i];

                if(ex < 0 || ex > graph[0].length - 1 || ey < 0 || ey > graph.length - 1) continue;
                if(graph[ey][ex] != 0) continue;

                graph[ey][ex] = 1;
                queue.offer(new int[]{ex, ey});
                ++영역_넓이;
            }
        }

        ++영역_수;
        영역_넓이_모음.add(영역_넓이);
    }
}
