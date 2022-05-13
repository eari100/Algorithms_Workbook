package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/11403 (경로 찾기)
 *@classfication: bfs
 **/
public class Q11403 {
    static int[][] graph;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new int[N][N];

        for(int i=0;i<graph.length;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<graph.length;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        for(int i=0;i<N;i++)
            bfs(i);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<visited.length;i++) {
            for(int j=0;j<visited.length;j++) {
                sb.append(visited[i][j]+" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static void bfs(int str) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(str);

        while( !queue.isEmpty() ) {
            int poll = queue.poll();
            for(int i=0;i<graph.length;i++) {
                if(graph[poll][i] == 1 && visited[str][i] == 0) {
                    visited[str][i] = 1;
                    queue.offer(i);
                }
            }
        }
    }
}
