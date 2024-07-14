package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/13023 (ABCDE)
 * @classification: dfs
 * @문제 푼 날짜 (자력솔): 24.07.14 (O)
 **/
// todo: union-find 활용 가능
public class Q13023 {
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        br.close();

        boolean answer = false;
        for(int i = 0; i<n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            answer = isCorrect(i, 0, visited);

            if(answer) {
                break;
            }
        }

        System.out.print(answer ? 1 : 0);
    }

    private static boolean isCorrect(int node, int lineCnt, boolean[] visited) {
        if(lineCnt == 4) {
            return true;
        }

        for(int friend : graph[node]) {
            if(!visited[friend]) {
                visited[friend] = true;
                boolean result = isCorrect(friend, lineCnt+1, visited);
                if(result) {
                    return true;
                }

                visited[friend] = false;
            }
        }

        return false;
    }
}
