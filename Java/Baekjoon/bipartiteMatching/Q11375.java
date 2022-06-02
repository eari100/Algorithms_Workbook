package Baekjoon.bipartiteMatching;

import java.io.*;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/11375 (열혈강호)
 * @classfication: bipartite matching
 * @reference: https://www.youtube.com/watch?v=PwXNTA0rpXc
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.06.02 (X)
 **/
public class Q11375 {
    static ArrayList<Integer>[] graph;
    static int[] matchBoard;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int matchCount = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        matchBoard = new int[M+1];
        visited = new boolean[M+1];

        for(int i=1;i<N+1;i++) {
            ArrayList<Integer> canDo = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            for(int j=0;j<cnt;j++) {
                canDo.add(Integer.parseInt(st.nextToken()));
            }

            graph[i] = canDo;
        }

        for(int i=1;i<=N;i++) {
            Arrays.fill(visited, false);
            if(bipartiteMatching(i)) ++matchCount;
        }

        System.out.print(matchCount);
    }

    private static boolean bipartiteMatching(int n) {
        for(int m : graph[n]) {
            if(visited[m]) continue;
            visited[m] = true;

            if(matchBoard[m] == 0 || bipartiteMatching(matchBoard[m])) {
                matchBoard[m] = n;
                return true;
            }
        }

        return false;
    }
}
