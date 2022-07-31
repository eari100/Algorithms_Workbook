package Baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/2744 (대소문자 바꾸기)
 * @classfication: string
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.31 (O)
 **/
public class Q2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] cvtStr = new char[str.length()];

        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);

            if(c >= 65 && c <= 90) cvtStr[i] = (char)(c+32);
            else cvtStr[i] = (char)(c-32);
        }

        System.out.print(cvtStr);
    }
}
