package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/1747 (소수&팰린드롬)
 * @classfication: math, 에라토스테네스의 체
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 23.01.17 (O, 에라토스테네스의 체 공식 참고함)
 **/
public class Q1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        System.out.print(searchPrimePalindrome(N));
    }

    private static int searchPrimePalindrome(int N) {
        if(N == 1) return 2;

        int primePalindrome = 0;

        for(int i=N;i<1003001+1;i++) {
            if(isPrime(i) && isPalindrome(i)) {
                primePalindrome = i;
                break;
            }
        }

        return primePalindrome;
    }

    private static boolean isPrime(int N) {
        for(int i=2;i*i<=N;i++)
            if(N % i == 0) return false;

        return true;
    }

    private static boolean isPalindrome(int N) {
        StringBuilder sb = new StringBuilder(String.valueOf(N));
        String reverse = sb.reverse().toString();
        String original = String.valueOf(N);

        return original.equals(reverse);
    }
}
