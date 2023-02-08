package Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@source: https://www.acmicpc.net/problem/1065 (한수)
 *@classfication: bruteforce
 * @문제 푼 날짜 (자력으로 풂?): 23.02.09 (O)
 **/
public class Q1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int result = 0;
        br.close();

        for(int i=1;i<x+1;i++)
            if(한수인지_판별하기(String.valueOf(i))) ++result;

        System.out.print(result);
    }

    private static boolean 한수인지_판별하기(String num) {
        int gap = -10;
        int tmp = Character.getNumericValue(num.charAt(0));

        for(int i=1;i<num.length();i++) {
            int nx = Character.getNumericValue(num.charAt(i));

            if(gap == -10) gap = tmp - nx;
            else if(tmp - nx != gap) return false;

            tmp = nx;
        }

        return true;
    }
}
