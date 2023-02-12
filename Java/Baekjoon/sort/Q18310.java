package Baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/18310 (안테나)
 * @classfication: sort
 * @문제 푼 날짜 (자력으로 풂?): 23.02.11 (O)
 **/
public class Q18310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] houses = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        for(int i=1;i<N+1;i++)
            houses[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(houses);

        System.out.print(N%2 == 0 ? houses[N/2] : houses[N/2+1]);
    }
}
