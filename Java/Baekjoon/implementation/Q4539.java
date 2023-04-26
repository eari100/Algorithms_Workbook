package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/4539 (반올림)
 * @classfication: implementation, math
 * @문제 푼 날짜 (자력으로 풂?): 23.04.26 (O)
 **/
// todo: Math 클래스를 없이 직접 수학적으로 구현해볼 것
public class Q4539 {
    public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int x = Integer.parseInt(br.readLine());
            int digit = getDigit(x);

            for(int i=1;i<digit;i++) {
                x = getRound(x, i);
            }

            result.append(x).append('\n');
        }

        br.close();

        System.out.print(result);
    }

    private static int getRound(int x, int digit) {
        double y = Math.pow(10, digit) * 1.0;
        return (int) (Math.round(x/y) * y);
    }

    private static int getDigit(int x) {
        return (int) Math.log10(x) + 1;
    }
}
