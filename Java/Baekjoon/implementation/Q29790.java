package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/29790 (임스의 메이플컵)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 23.09.08 (O)
 **/
public class Q29790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        if(N >= 1000 && (U >= 8000 || L >= 260))
            System.out.print("Very Good");
        else if(N >= 1000)
            System.out.print("Good");
        else
            System.out.print("Bad");

        br.close();
    }
}
