package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/15829 (Hashing)
 * @classfication: modular, hashing
 * @문제 푼 날짜 (자력으로 풂?): 23.05.27 (X, 모듈러 연산을 몰랐음)
 * @reference:
 * 모듈러 연산 :
 * (A + B) mod C = (A mod C + B mod C) mod C
 * (A - B) mod C = (A mod C - B mod C) mod C
 * (A * B) mod C = (A mod C * B mod C) mod C
 **/
public class Q15829 {
    static final int r = 31;
    static final int MODULAR = 1_234_567_891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] alphabetArray = br.readLine().toCharArray();
        br.close();

        long pow = 1;
        long hashCode = 0;

        for(int i=0;i<L;i++) {
            long hashCodeOne = convertToInt(alphabetArray[i]) * pow;
            pow = pow * r % MODULAR;
            hashCode += hashCodeOne % MODULAR;
        }

        System.out.print(hashCode % MODULAR);
    }

    private static int convertToInt(char alphabet) {
        return alphabet - 96;
    }
}
