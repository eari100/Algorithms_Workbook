package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@source: https://www.acmicpc.net/problem/1789 (수들의 합)
 *@classfication: greedy
 *@reference: 더 좋은 풀이(등차수열 활용): https://www.acmicpc.net/source/23293254
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.06 (O)
 **/
public class Q1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        br.close();

        long x = 1;
        long result = 0;
        while(x <= S) {
            S -= x;
            ++x;
            ++result;
        }

        System.out.print(result);
    }
}
