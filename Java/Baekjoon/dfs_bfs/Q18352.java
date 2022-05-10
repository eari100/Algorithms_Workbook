package Baekjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *@source: https://www.acmicpc.net/problem/18352 (특정 거리의 도시 찾기)
 *@classfication: bfs
 *@reference: https://www.acmicpc.net/board/view/75763
 **/
public class Q18352 {
    static ArrayList<ArrayList<Integer>> gragh = new ArrayList<>();
    static int[] memo;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        memo = new int[N];
        Arrays.fill(memo, 300000);
        memo[X-1] = 0;

        for(int i=0;i<N;i++) {
            gragh.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st2.nextToken()) - 1;
            int k = Integer.parseInt(st2.nextToken()) - 1;
            gragh.get(j).add(k);
        }

        br.close();

        dfs(X-1);

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<memo.length;i++) {
            if(memo[i] == K) sb.append(i+1).append('\n');
        }

        System.out.print(sb.toString().isEmpty() ? -1 : sb);
    }

    private static void dfs(int idx) {
        for(int i=0;i<gragh.get(idx).size();i++) {
            int x = gragh.get(idx).get(i);
            if(memo[idx]+1 < memo[x]) {
                memo[x] = memo[idx] + 1;
                if(memo[x] < K) {
                    dfs(x);
                }
            }
        }
    }
}
