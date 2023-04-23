package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2145 (숫자 놀이)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.04.23 (O)
 **/
public class Q2145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String N;

        while(!(N = br.readLine()).equals("0")) {
            while(N.length() > 1) {
                int sum = 0;

                for(char c : N.toCharArray()) {
                    sum += c - 48;
                }

                N = String.valueOf(sum);
            }

            result.append(N).append('\n');
        }

        br.close();

        System.out.print(result);
    }
}
