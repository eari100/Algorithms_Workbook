package Baekjoon.math.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @source: https://www.acmicpc.net/problem/1929 (소수 구하기)
 * @classfication: number theory
 * @reference: https://myjamong.tistory.com/139
 * @문제 푼 날짜 (자력으로 풂?): 23.10.01 (X, reference 참조)
 **/
public class Q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder result = new StringBuilder();

        for(int i=M;i<=N;i++) {
            if(i == 2) {
                result.append(2).append('\n');
                continue;
            }

            int x = (int)Math.ceil(Math.sqrt(i));
            for(int j=2;j<=x;j++) {
                if(i%j == 0) break;

                if(j==x) result.append(i).append('\n');
            }
        }

        System.out.print(result);
    }
}
