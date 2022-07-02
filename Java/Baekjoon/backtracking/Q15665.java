package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @source: https://www.acmicpc.net/problem/15665 (N과 M (11))
 * @classfication: backtracking
 * @reference: https://www.acmicpc.net/problem/15665 (Set 을 사용하지 않는 효율적인 풀이)
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.02 (O)
 **/
public class Q15665 {
    static List<Integer> list;
    static int N;
    static int M;
    static int[] memo;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memo = new int[M];

        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        br.close();

        list = new ArrayList<>(set);
        Collections.sort(list);

        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if(depth == M) {
            for(int i : memo) {
                sb.append(i).append(' ');
            }
            sb.append('\n');

            return;
        }

        for(int i : list) {
            memo[depth] = i;
            dfs(depth+1);
        }
    }
}
