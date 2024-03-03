package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * @source: https://www.acmicpc.net/problem/11478 (서로 다른 부분 문자열의 개수)
 * @classification: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.03.03 (O)
 **/
public class Q11478 {
    public static void main(String[] args) throws IOException {
        HashSet<String> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();

        for(int i=0;i<str.length();i++) {
            for(int j=i;j<str.length();j++) {
                set.add(str.substring(i, j+1));
            }
        }

        System.out.print(set.size());
    }
}
