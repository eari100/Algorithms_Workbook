package Baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/13277 (큰 수 곱셈)
 * @classfication: math, 임의의 정밀도
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.07.10 (O)
 **/
public class Q13277 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        System.out.print(A.multiply(B));
    }
}
