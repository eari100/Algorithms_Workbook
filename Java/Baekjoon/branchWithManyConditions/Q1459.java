package Baekjoon.branchWithManyConditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1459 (걷기)
 * @classfication: 조건 많은 분기
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.01 (X)
 **/
public class Q1459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());
        long max = Math.max(x, y);
        long min = Math.min(x, y);
        long abs = Math.abs(x - y);

        long cost1 = (x + y) * w;
        long cost2 = (x + y) % 2 == 0 ? max * s : (max - 1) * s + w;
        long cost3 = min * s + abs * w;

        System.out.print(Math.min(Math.min(cost1, cost2), cost3));
    }
}
