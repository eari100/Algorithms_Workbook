package Baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/14606 (피자 (Small))
 * @classfication: math, 등차수열의 합
 * @문제 푼 날짜 (자력으로 풂?): 23.08.24 (O)
 **/
public class Q14606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        System.out.print(sumArithmeticsSequence(1, 1, N-1));
    }

    private static int sumArithmeticsSequence(int a1, int d, int N) {
        return N * (2 * a1 + (N-1) * d) / 2;
    }
}
