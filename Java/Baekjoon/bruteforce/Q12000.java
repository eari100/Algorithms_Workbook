package Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @source: https://www.acmicpc.net/problem/12000 (Circular Barn (Bronze))
 * @classfication: bruteforce
 * @문제 푼 날짜 (자력으로 풂?): 23.01.29 (X, 지문 이해 불가)
 * @reference:
 *  - https://usaco.guide/problems/usaco-616-circular-barn/solution
 *  - https://codingbeginner.tistory.com/9
 **/
public class Q12000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] room = new int[N];
        int result = Integer.MAX_VALUE;

        for(int i=0;i<N;i++)
            room[i] = Integer.parseInt(br.readLine());

        br.close();

        for(int i=0;i<room.length;i++) {
            int tmp = 0;

            for(int j=0;j<room.length;j++) {
                if(j >= i) tmp += (j-i) * room[j];
            }
            result = Math.min(result, tmp);
        }

        System.out.print(result);
    }
}
