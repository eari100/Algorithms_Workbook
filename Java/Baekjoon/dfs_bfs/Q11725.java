package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/11725 (트리의 부모 찾기)
 * @classfication: tree, bfs
 * @reference: https://hongku.tistory.com/253 (트리의 부모 노드 저장하는 아이디어)
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.05.23 (X, 트리의 부모 노드 저장하는 아이디어를 떠올리지 못함)
 **/
public class Q11725 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }
        visited = new int[N+1];

        for(int i=1;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        br.close();

        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i=2;i<visited.length;i++)
            sb.append(visited[i]).append('\n');

        System.out.print(sb);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = -1;

        while( !queue.isEmpty() ) {
            int poll = queue.poll();

            for(int i : graph.get(poll)) {
                if(visited[i] == 0) {
                    queue.offer(i);
                    visited[i] = poll;
                }
            }
        }
    }
}
