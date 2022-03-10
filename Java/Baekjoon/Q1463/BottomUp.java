package Baekjoon.Q1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@source: https://www.acmicpc.net/problem/1463
 *@classfication: dp
 **/
public class BottomUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        br.close();

        int[] memoization = new int[X+1];

        for(int i=2;i<=X;i++) {
            memoization[i] = memoization[i-1]+1;
            if(i%3==0) memoization[i] = Math.min(memoization[i], memoization[i/3]+1);
            if(i%2==0) memoization[i] = Math.min(memoization[i], memoization[i/2]+1);
        }

        System.out.print(memoization[X]);
    }
}
