package Baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2292 (벌집)
 * @classfication: math
 * @문제 푼 날짜 (자력으로 풂?): 23.05.27 (O)
 **/
public class Q2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int tmp = 1;
        int move = 1;

        while(tmp < N) {
            tmp += 6 * move++;
        }

        System.out.print(move);
    }
}
