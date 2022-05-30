package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/15652 (N과 M (4))
 * @classfication: backtracking
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.05.29 (O)
 **/
public class Q15652 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sequence = new int[M+1];

        dfs(1, sequence);
        System.out.print(sb);
    }

    private static void dfs(int depth, int[] sequence) {
        if(depth == M+1) {
            for(int i=1;i<sequence.length;i++) {
                sb.append(sequence[i]+" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=1;i<=N;i++) {
            if(sequence[depth-1] <= i) {
                sequence[depth] = i;
                dfs(depth+1, sequence);
            }
        }
    }
}
