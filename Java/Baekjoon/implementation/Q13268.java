package Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/13268 (셔틀런)
 * @classfication: implementation
 * @문제 푼 날짜 (자력으로 풂?): 24.12.06 (O)
 **/
public class Q13268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int ci = 0;

        L1: while(n >= 0) {
            if(n == 0) {
                System.out.print(0);
                break;
            }

            for(int i=0;i<=ci;i++) {
                n -= 5;

                if(n <= 0) {
                    System.out.print(i+1);
                    break L1;
                }
            }

            for(int i=ci;i>=0;i--) {
                n -= 5;

                if(n < 0) {
                    System.out.print(i+1);
                    break L1;
                }
            }

            ci = (ci + 1) % 4;
        }
    }
}
