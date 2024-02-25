package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/10974 (모든 순열)
 * @classification: backtracking
 * @문제 푼 날짜 (자력으로 풂?): 24.02.25 (O)
 **/
public class Q10974 {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        backtracking(0, new boolean[n], new int[n]);

        System.out.print(result);
    }

    private static void backtracking(int depth, boolean[] visited, int[] seq) {
        if(depth == seq.length) {
            for(int num : seq)
                result.append(num).append(' ');

            result.append('\n');

            return;
        }

        for(int i=0;i<visited.length;i++) {
            if(visited[i]) continue;

            visited[i] = true;
            seq[depth] = i+1;
            backtracking(depth+1, visited, seq);
            visited[i] = false;
        }
    }
}
