package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/1953
 * @classfication: dfs
 **/
public class Q1953 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

        visited = new int[n];

        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int hateCnt = Integer.parseInt(st.nextToken());

            for(int j=0;j<hateCnt;j++) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                graph.get(i).add(x);
            }
        }
        br.close();

        for(int i=0;i<n;i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(i);
            }
        }

        System.out.print(printer(visited));
    }

    private static void dfs(int idx) {
        for(int i : graph.get(idx)) {
            if(visited[i] == 0) {
                visited[i] = visited[idx] * -1;
                dfs(i);
            }
        }
    }

    private static String printer(int[] visited) {
        int blueCnt = 0;
        StringBuilder blueTeam = new StringBuilder();
        int redCnt = 0;
        StringBuilder redTeam = new StringBuilder();

        for(int i=0;i<visited.length;i++) {
            if(visited[i]==1) {
                ++blueCnt;
                blueTeam.append(i+1).append(' ');
            } else {
                ++redCnt;
                redTeam.append(i+1).append(' ');
            }
        }

        return String.format("%s%s%s%s%s%s%s", blueCnt, '\n', blueTeam, '\n', redCnt, '\n', redTeam);
    }
}
