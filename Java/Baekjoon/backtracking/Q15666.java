package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/15666 (N과 M (12))
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.29 (O)
 **/
public class Q15666 {
    static int[] memo;
    static int M;
    static StringBuilder sb;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) set.add(Integer.parseInt(st.nextToken()));

        list = new ArrayList<>(set);
        Collections.sort(list);

        memo = new int[M+1];

        br.close();

        sb = new StringBuilder();

        dfs(1);

        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if(depth == M+1) {
            for(int i=1;i<memo.length;i++) sb.append(memo[i]).append(' ');

            sb.append('\n');
            return;
        }

        for(int i : list) {
            if(memo[depth-1] > i) continue;

            memo[depth] = i;
            dfs(depth+1);
        }
    }
}
