package Baekjoon.math.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2553 (마지막 팩토리얼 수)
 * @classfication: number theory
 * @문제 푼 날짜 (자력으로 풂?): 23.05.21 (X)
 **/
public class Q2553 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        long lastFactorialNum = 1;

        for(int i=1;i<N+1;i++) {
            // overflow 방지
            lastFactorialNum = lastFactorialNum * i % 10_000_000;

            while (lastFactorialNum % 10 == 0)
                lastFactorialNum /= 10;
        }

        System.out.print(lastFactorialNum % 10);
    }
}
