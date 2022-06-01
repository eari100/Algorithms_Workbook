package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/14468 (소가 길을 건너간 이유 2)
 * @classfication: implementation
 * @문제 푼 날짜 (혼자 힘으로 풂?)
 * 1. 22.06.01 (X)
 **/
public class Q14468 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] start = new int[26];
        int[] end = new int[26];
        int answer = 0;

        for(int i=0;i<str.length();i++) {
            int idx = str.charAt(i) - 'A';

            if(start[idx] == 0) start[idx] = i+1;
            else end[idx] = i+1;
        }

        for(int i=0;i<26;i++) {
            for(int j=0;j<26;j++) {
                if(start[i] < start[j] && start[j] < end[i] && end[i] < end[j]) ++answer;
            }
        }

        System.out.print(answer);
    }
}