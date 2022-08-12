package Baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @source: https://www.acmicpc.net/problem/5596 (시험 점수)
 * @classfication: math, stream
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.08.12 (O)
 **/
public class Q5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int mingukTotalSum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        int mansaeTotalSum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();

        br.close();

        System.out.print(Math.max(mingukTotalSum, mansaeTotalSum));
    }
}
