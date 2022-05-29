package Baekjoon.bitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/12813 (이진수 연산)
 * @classfication: bitMask
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.05.29 (X)
 **/
public class Q12813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        br.close();

        StringBuilder and = new StringBuilder();
        StringBuilder or = new StringBuilder();
        StringBuilder xor = new StringBuilder();
        StringBuilder notA = new StringBuilder();
        StringBuilder notB = new StringBuilder();

        for(int i=0;i<A.length();i++) {
            int bit1 = Integer.parseInt(String.valueOf(A.charAt(i)));
            int bit2 = Integer.parseInt(String.valueOf(B.charAt(i)));

            and.append(bit1 & bit2);
            or.append(bit1 | bit2);
            xor.append(bit1 ^ bit2);
            notA.append(bit1^1);
            notB.append(bit2^1);
        }

        System.out.println(and);
        System.out.println(or);
        System.out.println(xor);
        System.out.println(notA);
        System.out.println(notB);
    }
}
