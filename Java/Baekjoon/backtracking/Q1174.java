package Baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @source: https://www.acmicpc.net/problem/1174 (줄어드는 수)
 * @classfication: backtracking
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.25 (O, 다시 한 번 풀어보자)
 **/
public class Q1174 {
    static List<Long> memo;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        memo = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        br.close();

        long result = -1;

        if(N < 1024) {
            dfs(10, 0);
            Collections.sort(memo);
            result = memo.get(N-1);
        }

        System.out.print(result);
    }

    private static void dfs(int prev, long result) {
        for(int i=0;i<prev;i++) {
            long x = (result * 10) + i;
            memo.add(x);

            dfs(i, x);
        }
    }
}
