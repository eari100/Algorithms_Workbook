package Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1817 (짐 챙기는 숌)
 * @classfication: greedy
 * @문제 푼 날짜 (자력으로 풂?)
 * 1. 22.07.07 (O)
 **/
public class Q1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int boxCnt = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N > 0) st = new StringTokenizer(br.readLine());
        else boxCnt = 0;

        int w = M;
        for(int i=0;i<N;i++) {
            int book = Integer.parseInt(st.nextToken());
            if(book <= w) {
                w -= book;
            } else {
                w = M - book;
                ++boxCnt;
            }
        }

        System.out.println(boxCnt);
    }
}
