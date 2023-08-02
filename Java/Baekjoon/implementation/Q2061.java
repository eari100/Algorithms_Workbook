package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/2061 (좋은 암호)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.08.02 (O)
 **/
public class Q2061 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        br.close();

        BigInteger num = new BigInteger(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        for (int i = 2; i < limit; i++) {
            if (isRemainderZero(num, i)) {
                result.append("BAD ").append(i);
                break;
            }
        }

        System.out.print(result.length() == 0 ? "GOOD" : result);
    }

    private static boolean isRemainderZero(BigInteger num, int divisor) {
        return num.mod(BigInteger.valueOf(divisor)).equals(BigInteger.ZERO);
    }
}
