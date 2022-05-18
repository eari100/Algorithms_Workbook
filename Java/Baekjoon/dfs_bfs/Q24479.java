package Baekjoon.dfs_bfs;

import java.io.*;
import java.util.*;

/**
 *@source: https://www.acmicpc.net/problem/24479 (알고리즘 수업 - 깊이 우선 탐색 1)
 *@classfication: dfs
 **/
public class Q24479 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int visitedOrder = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++)
            graph.add(new ArrayList<>());

        visited = new int[N];

        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()) - 1;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(ArrayList<Integer> list : graph)
            Collections.sort(list);

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int v : visited)
            sb.append(v).append('\n');

        System.out.print(sb);
    }

    private static void dfs(int x) {
        visited[x] = visitedOrder;

        ArrayList<Integer> list = graph.get(x);
        for(int i=0;i<list.size();i++) {

            int next = list.get(i);

            if(visited[next] == 0) {
                ++visitedOrder;
                dfs(next);
            }
        }
    }
}
