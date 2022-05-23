package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/9663 (N-Queen)
 * @classfication: backtracking
 * @reference: https://chanhuiseok.github.io/posts/baek-1 (재귀함수의 매개변수를 행의 값을 주게 되면 depth 를 check 할 필요가 없어짐)
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.05.23 (O)
 **/
public class Q9663 {
    static int depth = 0;
    static int[] memo;
    static int N;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new int[N];
        br.close();

        for(int i=0;i<N;i++) {
            backtracking(i);
        }

        System.out.print(answer);
    }

    private static void backtracking(int col) {
        memo[depth] = col;

        for(int i=0;i<depth;i++) {
            if(memo[i] == col) return;
            if(Math.abs(i-depth) == Math.abs(memo[i] -col)) return;
        }

        if(depth == N-1) {
            ++answer;
            return;
        }

        for(int i=0;i<N;i++) {
            ++depth;
            backtracking(i);
            --depth;
        }
    }
}
