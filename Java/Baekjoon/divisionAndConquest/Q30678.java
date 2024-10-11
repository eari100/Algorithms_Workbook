package Baekjoon.divisionAndConquest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/30678 (별 안에 별 안에 별 찍기)
 * @classification: division and conquest, recursion
 * @문제 푼 날짜 (자력으로 풂?): 24.10.11 (X)
 **/
public class Q30678 {
    static StringBuilder answer = new StringBuilder();
    static final boolean[][] towel = {
            {false, false, true, false, false},
            {false, false, true, false, false},
            {true, true, true, true, true},
            {false, true, true, true, false},
            {false, true, false, true, false},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int len = (int) Math.pow(5, n);

        if(n > 0) {
            for(int i=0;i<len;i++) {
                for(int j=0;j<len;j++) {
                    bt(i, j, len);
                }
                answer.append('\n');
            }
        } else {
            answer.append('*');
        }

        System.out.print(answer);
    }

    private static void bt(int x, int y, int len) {
        if(len == 5) {
            if(towel[x][y]) {
                answer.append('*');
            } else {
                answer.append(' ');
            }
        } else {
            int nextLen = len / 5;
            if(towel[x / nextLen][y / nextLen]) {
                bt(x % nextLen, y % nextLen, nextLen);
            } else {
                answer.append(' ');
            }
        }
    }
}
