package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/1043 (거짓말)
 * @classfication: dfs
 * @문제 푼 날짜 (자력으로 풂?): 23.07.18 (O, 사고로 힌트를 씀)
 **/
// 1. todo: union find로 풀어볼 것
// 2. todo: 코드 가독성 있게 수정할 것
public class Q1043 {
    static ArrayList<Set<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] truths;
        st = new StringTokenizer(br.readLine());
        int truthCnt = Integer.parseInt(st.nextToken());
        truths = new int[truthCnt];

        for(int i=0;i<truthCnt;i++) {
            truths[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for(int i=0;i<N;i++) {
            graph.add(new HashSet<>());
        }

        visited = new boolean[N];
        ArrayList<ArrayList<Integer>> networks = new ArrayList<>();

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int personCnt = Integer.parseInt(st.nextToken());
            networks.add(new ArrayList<>());

            for(int j=0;j<personCnt;j++) {
                int person = Integer.parseInt(st.nextToken()) - 1;
                networks.get(i).add(person);
            }

            for(int j=0;j<networks.get(i).size();j++) {
                int from = networks.get(i).get(j);
                for(int k=0;k<networks.get(i).size();k++) {
                    int to = networks.get(i).get(k);

                    if(j == k) continue;

                    graph.get(from).add(to);
                }
            }
        }

        br.close();

        for(int i=0;i<truths.length;i++) {
            int node = truths[i];
            if( !visited[node] ) {
                visited[node] = true;
                dfs(node);
            }
        }

        int lieCount = 0;

        for(int i=0;i<networks.size();i++) {
            for(int j=0;j<networks.get(i).size();j++) {
                if(visited[networks.get(i).get(j)]) break;

                if(j == networks.get(i).size() - 1) ++lieCount;
            }
        }

        System.out.print(lieCount);
    }

    private static void dfs(int node) {
        Iterator iter = graph.get(node).iterator();
        while(iter.hasNext()) {
            int node2 = (int) iter.next();
            if( !visited[node2] ) {
                visited[node2] = true;
                dfs(node2);
            }
        }
    }
}
