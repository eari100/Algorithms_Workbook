package Baekjoon.math.combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/11050 (이항 계수 1)
 * @classfication: combinatorics
 * @문제 푼 날짜 (자력으로 풂?): 23.04.28 (X, 조합 구하는 수식 공부했음)
 * @reference: https://st-lab.tistory.com/159 (공부하면 좋은 링크)
 **/
public class Q11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int x = multiplyFromTo(N, N+1-K);
        int y = multiplyFromTo(K, 1);

        System.out.print(x/y);
    }

    private static int multiplyFromTo(int start, int end) {
        int result = 1;
        for(int i=start;i>=end;i--) {
            result *= i;
        }

        return result;
    }
}
