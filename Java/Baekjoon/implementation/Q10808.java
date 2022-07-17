package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/10808
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.15 (X, 귀찮아서 답지 봄)
 **/
public class Q10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        br.close();

        int[] alpha = new int[26];

        for(char c : S.toCharArray())
            ++alpha[(int) c - 97];

        StringBuilder result = new StringBuilder();

        for(int i : alpha)
            result.append(i).append(' ');

        System.out.print(result);
    }
}
